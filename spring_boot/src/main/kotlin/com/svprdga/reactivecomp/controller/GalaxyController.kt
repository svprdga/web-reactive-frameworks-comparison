package com.svprdga.reactivecomp.controller

import com.svprdga.reactivecomp.datasource.GalaxyRepository
import com.svprdga.reactivecomp.model.Galaxy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class GalaxyController {

    @Autowired
    private lateinit var galaxyRepository: GalaxyRepository

    @RequestMapping(
            value = "/galaxies",
            method = [RequestMethod.GET])
    fun getGalaxies(): Iterable<Galaxy> {
        return galaxyRepository.findAll()
    }

}