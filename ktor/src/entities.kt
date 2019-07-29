package com.reactivecomp

import me.liuwj.ktorm.entity.Entity
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

interface Galaxy : Entity<Galaxy> {
    val id: Int
    val name: String
    val description: String
}

object  Galaxies : Table<Galaxy>("galaxy") {
    val id by int("id").primaryKey().bindTo { it.id }
    val name by varchar("name").bindTo { it.name }
    val description by varchar("description").bindTo { it.description }
}