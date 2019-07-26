package com.svprdga.reactivecomp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "galaxy")
data class Galaxy(
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        val id: Long = -1,
        val name: String = "",
        val description: String = "") {

    override fun toString(): String {
        return "Galaxy[id=$id, name=$name, description=${description.substring(0, 30)}"
    }
}