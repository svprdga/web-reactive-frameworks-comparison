package com.svprdga.vertxspring.verticle

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.svprdga.reactivecomp.network.Galaxies
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.vertx.core.AbstractVerticle
import io.vertx.core.Handler
import io.vertx.core.eventbus.Message
import io.vertx.core.logging.LoggerFactory
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.entity.findAll

const val ALL_GALAXIES = "vertxspring.all.galaxies"

class GalaxyVerticle(        )
    : AbstractVerticle() {

    private val mapper = ObjectMapper()
    private val log = LoggerFactory.getLogger(GalaxyVerticle::class.java)

    override fun start() {
        super.start()
        vertx.eventBus().consumer<String>(ALL_GALAXIES).handler(allGalaxiesHandler())
        Database.connect(getConnection())
        mapper.findAndRegisterModules()
    }

    private fun allGalaxiesHandler(): Handler<Message<String>> {
        return Handler { message ->
            vertx.executeBlocking<String>({ future ->
                try {
                    var movies = Galaxies.findAll()
                    val moviesJson = mapper.writeValueAsString(movies)
                    future.complete(moviesJson)
                } catch (e: JsonProcessingException) {
                    log.error(e)
                    future.fail(e)
                }
            }, { result ->
                if (result.succeeded()) {
                    message.reply(result.result())
                } else {
                    message.reply(result.cause().toString())
                }
            });

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