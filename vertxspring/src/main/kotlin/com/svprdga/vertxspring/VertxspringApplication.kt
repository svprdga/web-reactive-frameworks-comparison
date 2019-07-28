package com.svprdga.vertxspring

import com.svprdga.vertxspring.verticle.GalaxyVerticle
import com.svprdga.vertxspring.verticle.MainVerticle
import io.vertx.core.Vertx
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
	val context = AnnotationConfigApplicationContext(SpringConfig::class.java)
	val vertx = Vertx.vertx()
	vertx.deployVerticle(GalaxyVerticle(context))
	vertx.deployVerticle(MainVerticle())
}
