package com.svprdga.vertxspring.datasource

import com.svprdga.vertxspring.model.Galaxy
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GalaxyRepository : CrudRepository<Galaxy, Long>
