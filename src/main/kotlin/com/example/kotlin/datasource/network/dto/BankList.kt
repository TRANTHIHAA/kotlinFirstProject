package com.example.kotlin.datasource.network.dto

import com.example.kotlin.model.entity.Bank

data class BankList(
    val results: Collection<Bank>
)
