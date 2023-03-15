package com.example.kotlin.model.entity

import jakarta.persistence.*

@Entity
data class Bank(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String? = null,
    var import: Float? = 0F,
    var export: Float? = 0F,
    ){
    constructor(): this(0, "",0.0F,0.0F)
}

