package com.github.evgdim.coroutines

import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ClientRepository: ReactiveCrudRepository<Clients, Long> {}


data class Clients(@Id val id: Long,
                  val first_name: String,
                  val last_name: String,
                  val email: String,
                  val photo: String,
                  val del_flag: Boolean)