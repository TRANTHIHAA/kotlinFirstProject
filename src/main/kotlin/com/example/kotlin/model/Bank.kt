package com.example.kotlin.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Bank(
    @Id
    val id: Long = 0,

    val name: String,

    val import: Float,

    val export: Float,

){
    constructor(): this(0, "",0.0F,0.0F)
}
