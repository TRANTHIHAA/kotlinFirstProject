package com.example.kotlin.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Account(
    @Id
    val id: Long = 0,
    val username: String,
    val password: String,
    val email: String,

    @ManyToOne
    @JoinColumn(name="BANK")
    val bank: Bank?,
    ) {
    constructor(): this(0, "","","",null)
}