package com.svprdga.ktorexposed

import org.jetbrains.exposed.sql.Table

data class Galaxy(
    val id: Int,
    val name: String,
    val description: String
)

object  Galaxies : Table("galaxy") {
    val id = integer("id").primaryKey().autoIncrement()
    val name = varchar("name", 100)
    val description = varchar("description",3000)
}