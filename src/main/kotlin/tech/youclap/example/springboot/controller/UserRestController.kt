package tech.youclap.example.springboot.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import tech.youclap.example.springboot.model.ApiError
import tech.youclap.example.springboot.model.User
import tech.youclap.example.springboot.service.UserService
import tech.youclap.example.springboot.service.UserServiceRepresentable

@RestController
@RequestMapping("/user")
class UserRestController(
    private val service: UserServiceRepresentable
) {

    private companion object {
        private val logger = LoggerFactory.getLogger(UserRestController::class.java)
    }

    @GetMapping("/{userID}")
    fun read(@PathVariable userID: Int): Mono<User> {

        logger.info("👽 getUser '$userID'")

        return service.read(userID)
    }

    @PostMapping
    fun create(@RequestBody user: User): Mono<User> {

        logger.info("🤘 create '$user'")

        return service.create(user)
    }

    @DeleteMapping("/{userID}")
    fun delete(@PathVariable userID: Int): Mono<Void> {

        logger.info("🤘 delete '$userID'")

        // TODO change return type
        return service.delete(userID)
    }

    @ExceptionHandler(UserService.Error::class)
    fun handleException(error: UserService.Error): ResponseEntity<ApiError> {

        logger.error("❌  code='${error.code}' message='${error.message}'", error.cause)

        val apiError = ApiError(error.code, error.message)

        val httpStatus = when (error) {
            is UserService.Error.MissingUser -> HttpStatus.NOT_FOUND
        }

        return ResponseEntity(apiError, httpStatus)
    }
}
