package com.example.kotlin.transformer

import com.example.kotlin.model.dto.AddAccount
import com.example.kotlin.model.dto.ViewAccount
import com.example.kotlin.model.entity.Account
import com.example.kotlin.model.entity.Bank
import org.springframework.stereotype.Component


@Component
class AddAccountRequestTransformer:Transformer<AddAccount,Account> {

    override fun transform(source: AddAccount): Account {
        return Account(
            0,source.username?:"", source.password?:"", source.email?:"", source.bank
        )
    }
}
