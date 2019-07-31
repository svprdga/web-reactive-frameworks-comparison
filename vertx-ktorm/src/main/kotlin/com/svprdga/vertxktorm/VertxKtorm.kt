package com.svprdga.vertxktorm

import com.svprdga.vertxktorm.verticle.GalaxyVerticle
import com.svprdga.vertxktorm.verticle.MainVerticle
import io.vertx.core.Vertx

open class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val vertx = Vertx.vertx()
            vertx.deployVerticle(GalaxyVerticle())
            vertx.deployVerticle(MainVerticle())
        }
    }
}