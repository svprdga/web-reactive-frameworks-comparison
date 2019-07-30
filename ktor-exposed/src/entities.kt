package com.reactivecomp

import org.jetbrains.exposed.sql.Table

//import me.liuwj.ktorm.entity.Entity
//import me.liuwj.ktorm.schema.Table
//import me.liuwj.ktorm.schema.int
//import me.liuwj.ktorm.schema.varchar

//interface Galaxy : Entity<Galaxy> {
//    val id: Int
//    val name: String
//    val description: String
//}
//
//object  Galaxies : Table<Galaxy>("galaxy") {
//    val id by int("id").primaryKey().bindTo { it.id }
//    val name by varchar("name").bindTo { it.name }
//    val description by varchar("description").bindTo { it.description }
//}

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