package com.reactivecomp

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.entity.findAll

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    Database.connect(getConnection())

    val client = HttpClient(Apache) {
    }

    routing {
        get("/galaxies") {
            call.respond(Galaxies.findAll())
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

