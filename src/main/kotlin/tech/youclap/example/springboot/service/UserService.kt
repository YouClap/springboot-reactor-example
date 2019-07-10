package tech.youclap.example.springboot.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import tech.youclap.example.springboot.model.User
import tech.youclap.example.springboot.repository.UserRepository
import tech.youclap.example.springboot.shared.MISSING_USER

@Service
class UserService(
    private val userRepository: UserRepository
) : UserServiceRepresentable {

    private companion object {
        private val logger = LoggerFactory.getLogger(UserService::class.java)
    }

    override fun read(userID: Int): Mono<User> {

        return userRepository.findById(userID)
            .single()
            .onErrorMap {
                Error.MissingUser(it)
            }
    }

    override fun create(user: User): Mono<User> {

        // Ensure that we create a new user TODO check if we can remove null
        val newUser = user.copy(id = null)

        return userRepository.save(newUser)
            .single()
        // TODO add custom error handling
    }

    override fun delete(userID: Int): Mono<Void> {

        return userRepository.deleteById(userID)
            .single()
            .onErrorMap {
                Error.MissingUser(it)
            }
    }

    sealed class Error(
        val code: String,
        override val message: String,
        override val cause: Throwable?
    ) : Throwable(code, cause) {

        data class MissingUser(override val cause: Throwable? = null) : Error(MISSING_USER, "User not found", cause)
    }
}
