package com.svprdga.reactivecomp

import com.svprdga.vertxspring.verticle.GalaxyVerticle
import com.svprdga.vertxspring.verticle.MainVerticle
import io.vertx.core.Vertx


fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    vertx.deployVerticle(GalaxyVerticle())
    vertx.deployVerticle(MainVerticle())
}