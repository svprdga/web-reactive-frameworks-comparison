package com.svprdga.springboot.controller

import com.svprdga.springboot.datasource.GalaxyRepository
import com.svprdga.springboot.model.Galaxy
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