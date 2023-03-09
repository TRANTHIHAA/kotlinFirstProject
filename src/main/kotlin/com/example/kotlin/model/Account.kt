package com.example.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor


@Entity
data class Account(
    @Id
    val id: Long = 0,

    val username: String,

    val password: String,

    val email: String
) {
     constructor(): this(0, "","","")

}
