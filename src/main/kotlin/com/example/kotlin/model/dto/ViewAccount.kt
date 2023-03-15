package com.example.kotlin.model.dto

import com.example.kotlin.model.entity.Bank
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

class ViewAccount(val id: Long? = 0,
                  val username: String,
                  val password: String,
                  val email: String,
                  val bank: String) {
}
