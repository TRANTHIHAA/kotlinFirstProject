package com.example.kotlin.transformer

import com.example.kotlin.model.dto.ViewAccount
import com.example.kotlin.model.entity.Account

fun Account?.toAccountResponse(): ViewAccount {
    return ViewAccount(
        id = this?.id ?: 1L,
        username = this?.username ?: "",
        password= this?.password ?: "",
        email= this?.email ?: "",
        bank= this?.bank?.name?:""
    )
}
