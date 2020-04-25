package com.github.evgdim.coroutines

import kotlinx.coroutines.flow.Flow
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client")
class ClientController(private val clientService: ClientService) {
    val logger = LoggerFactory.getLogger(ClientController::class.java)
    @GetMapping
    suspend fun get(): Flow<Clients> {
        logger.info("before")
        val findAll = clientService.findAll()
        logger.info("after")
        return findAll
    }

    @GetMapping("/{id}")
    suspend fun getById(@PathVariable id: Long): Clients? {
        logger.info("before")
        val findAll = clientService.findById(id)
        logger.info("after")
        return findAll
    }
}