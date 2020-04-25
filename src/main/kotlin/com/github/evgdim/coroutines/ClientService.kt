package com.github.evgdim.coroutines

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

interface ClientService {
    suspend fun findAll(): Flow<Clients>
    suspend fun findById(id: Long): Clients?
}
@Service
class ClientServiceImpl(private val clientRepository: ClientRepository): ClientService {
    override suspend fun findAll() = clientRepository.findAll().asFlow()
    override suspend fun findById(id: Long) = clientRepository.findById(id).awaitFirstOrNull()

}