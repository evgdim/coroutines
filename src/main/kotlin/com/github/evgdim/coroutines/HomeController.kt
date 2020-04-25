package com.github.evgdim.coroutines

import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {
    val logger = LoggerFactory.getLogger(HomeController::class.java)
    @GetMapping
    suspend fun index(): String {
        logger.info("index")
        delay(1000)
        logger.info("after")
        return "home"
    }
}

