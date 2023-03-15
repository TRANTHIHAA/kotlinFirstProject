package com.example.kotlin.model.dto

import com.example.kotlin.model.entity.Bank

class AddAccount(val username: String? = null,
                 val password: String? = null,
                 val email: String? = null,
                 val bank: Bank? = null) {
}
