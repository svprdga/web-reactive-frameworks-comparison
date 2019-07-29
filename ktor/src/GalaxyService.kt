package com.reactivecomp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class GalaxyService {

    suspend fun getAllGalaxies(): List<Galaxy> = dbQuery {
        Galaxies.selectAll().map { toGalaxies(it) }
    }

    suspend fun <T> dbQuery(block: () -> T): T =
        withContext(Dispatchers.IO) {
            transaction { block() }
        }

    private fun toGalaxies(row: ResultRow): Galaxy =
        Galaxy(
            id = row[Galaxies.id],
            name = row[Galaxies.name],
            description = row[Galaxies.description]
        )

}