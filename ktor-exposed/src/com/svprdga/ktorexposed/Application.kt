package com.svprdga.ktorexposed

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module() {
    install(ContentNegotiation) {
        gson {
        }
    }

    Database.connect(getConnection())

    val client = HttpClient(Apache) {
    }

    val service = GalaxyService()

    routing {
        get("/galaxies") {
            call.respond(service.getAllGalaxies())
        }
    }
}

private fun getConnection(): HikariDataSource {
    val config = HikariConfig()
    config.driverClassName = "org.postgresql.Driver"
    config.jdbcUrl = "jdbc:postgresql://localhost:5432/reactivecomp_db"
    config.username = "reactivecomp_user"
    config.password = "reactivecomp_pwd"
    config.maximumPoolSize = 10
    config.isAutoCommit = false
    config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    config.validate()

    return HikariDataSource(config)
}





