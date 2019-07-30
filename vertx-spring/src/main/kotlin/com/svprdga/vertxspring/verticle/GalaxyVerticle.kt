package com.svprdga.vertxspring.verticle

import com.fasterxml.jackson.core.JsonProcessingException
import com.svprdga.vertxspring.service.GalaxyService
import io.vertx.core.AbstractVerticle
import io.vertx.core.Handler
import io.vertx.core.eventbus.Message
import io.vertx.core.json.Json
import io.vertx.core.logging.LoggerFactory
import org.springframework.context.ApplicationContext

const val ALL_GALAXIES = "vertxspring.all.galaxies"

class GalaxyVerticle(
        _context: ApplicationContext)
    : AbstractVerticle() {

    private val mapper = Json.mapper;
    private val log = LoggerFactory.getLogger(GalaxyVerticle::class.java)

    private val service: GalaxyService = _context.getBean("galaxyService") as GalaxyService

    override fun start() {
        super.start()
        vertx.eventBus().consumer<String>(ALL_GALAXIES).handler(allGalaxiesHandler(service))
    }

    private fun allGalaxiesHandler(service: GalaxyService): Handler<Message<String>> {
        return Handler { message ->
            vertx.executeBlocking<String>({ future ->
                try {
                    future.complete(mapper.writeValueAsString(service.getAllGalaxies()))
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