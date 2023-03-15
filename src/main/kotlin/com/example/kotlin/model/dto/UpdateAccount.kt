package com.example.kotlin.model.dto

import com.example.kotlin.model.entity.Bank

class UpdateAccount(val id: Long,
                    val username: String? = null,
                    val password: String? = null,
                    val email: String? = null,
                    val bank: Bank? = null) {
}
