package tech.youclap.example.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootExampleApplication

fun main(args: Array<String>) {
    runApplication<SpringBootExampleApplication>(*args)
}
