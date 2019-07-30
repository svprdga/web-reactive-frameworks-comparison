package com.svprdga.vertxspring.service

import com.svprdga.vertxspring.datasource.GalaxyRepository
import com.svprdga.vertxspring.model.Galaxy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GalaxyService {

    @Autowired
    private lateinit var repository: GalaxyRepository

    fun getAllGalaxies(): Iterable<Galaxy> {
        return repository.findAll()
    }
}