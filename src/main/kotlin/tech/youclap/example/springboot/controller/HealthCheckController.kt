package tech.youclap.example.springboot.controller

import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/healthcheck")
class HealthCheckController {

    @GetMapping
    @ResponseStatus(NO_CONTENT)
    fun healthcheck() {}
}
