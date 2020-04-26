package com.github.evgdim.coroutines.user

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val usersRepository: UsersRepository) {
    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/{email}")
    suspend fun getByEmail(@PathVariable email: String): User? {
        logger.info("before")
        val user = usersRepository.getUser(email)
        logger.info("after")
        return user
    }
}