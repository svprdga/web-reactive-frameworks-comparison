package com.svprdga.springboot.datasource

import com.svprdga.springboot.model.Galaxy
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GalaxyRepository : CrudRepository<Galaxy, Long>
