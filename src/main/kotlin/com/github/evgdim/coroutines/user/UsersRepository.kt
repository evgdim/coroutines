package com.github.evgdim.coroutines.user

import io.r2dbc.spi.Row
import io.r2dbc.spi.RowMetadata
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.slf4j.LoggerFactory
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class UsersRepository(private val client: DatabaseClient) {
    private val logger = LoggerFactory.getLogger(UsersRepository::class.java)
    suspend fun getUser(email: String): User? {
        return client.execute("select id, email from gcpco_users where email = :email")
                .bind("email", email)
                .map {row: Row, rm: RowMetadata ->
                    User(row.get("id", BigDecimal::class.java)!!.toLong(),
                            row.get("email", String::class.java)!!)
                }
                .all()
                .awaitFirstOrNull()
    }
}

data class User(val id: Long, val email: String)