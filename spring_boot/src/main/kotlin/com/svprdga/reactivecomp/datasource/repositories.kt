package com.svprdga.reactivecomp.datasource

import com.svprdga.reactivecomp.model.Galaxy
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GalaxyRepository : CrudRepository<Galaxy, Long>
