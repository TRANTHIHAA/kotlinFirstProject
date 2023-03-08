package com.example.kotlin.datasource.network.dto

import com.example.kotlin.model.Bank

data class BankList(
    val results: Collection<Bank>
)
