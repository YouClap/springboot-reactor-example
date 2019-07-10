package tech.youclap.example.springboot.service

import reactor.core.publisher.Mono
import tech.youclap.example.springboot.model.User

interface UserServiceRepresentable {

    fun read(userID: Int): Mono<User>

    fun create(user: User): Mono<User>

    fun delete(userID: Int): Mono<Void>
}
