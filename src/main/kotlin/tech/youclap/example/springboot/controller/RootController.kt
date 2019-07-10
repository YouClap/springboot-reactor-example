package tech.youclap.example.springboot.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class RootController {

    private companion object {
        private val logger = LoggerFactory.getLogger(RootController::class.java)
    }

    @GetMapping
    fun index(): String {

        logger.info("🚀 Request received")

        return "YouClap Rocks 🤘"
    }
}
