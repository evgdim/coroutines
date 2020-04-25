package com.github.evgdim.coroutines

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class CoroutinesApplication {
	@Bean
	fun connectionFactory(): ConnectionFactory {
		return ConnectionFactories.get(ConnectionFactoryOptions.builder()
				.option(DRIVER, "pool")
				.option(PROTOCOL, "postgresql") // driver identifier, PROTOCOL is delegated as DRIVER by the pool.
				.option(HOST, "localhost")
				.option(PORT, 5432)
				.option(USER, "gcpco-usr")
				.option(PASSWORD, "gcpco-usr")
				.option(DATABASE, "gcpco")
				.build())
	}
}

fun main(args: Array<String>) {
	runApplication<CoroutinesApplication>(*args)
}
