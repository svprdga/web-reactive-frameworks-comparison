package com.svprdga.vertxktorm.verticle

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpMethod.GET

class MainVerticle : AbstractVerticle() {

    override fun start() {
        super.start()
        val server = vertx.createHttpServer()
        server.requestHandler { request ->
            if (request.method() == GET) {

                request.response().isChunked = true

                if (request.path() == "/galaxies") {

                    vertx.eventBus().send<String>(ALL_GALAXIES, "") { result ->
                        if (result.succeeded()) {
                            request.response().setStatusCode(200)
                                    .write(result.result().body()).end()
                        } else {
                            request.response().setStatusCode(500)
                                    .write(result.cause().toString()).end()
                        }
                    }

                } else {
                    request.response().setStatusCode(404).end()
                }

            } else {
                request.response().setStatusCode(405).end()
            }
        }

        server.listen(8000)
    }
}