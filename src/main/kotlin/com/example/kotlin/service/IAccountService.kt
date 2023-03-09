package com.example.kotlin.service

import com.example.kotlin.datasource.IAccount
import com.example.kotlin.model.Account
import com.example.kotlin.model.ViewAccount
import com.example.kotlin.model.toView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IAccountService {
    @Autowired
    lateinit var iAccount: IAccount

    fun findAll(): Iterable<ViewAccount> =
        iAccount.findAll().map { it.toView() }

    fun createAccount(account: Account): Account {
        if (iAccount.findById(account.id).isPresent ){
            throw IllegalArgumentException("Account ${account.username} already exists.")
        }
       return iAccount.save(account)
    }

    fun editAccount(account: Account): Account {
        if (!iAccount.findById(account.id).isPresent ){
            throw IllegalArgumentException("Account ${account.username} doesn't exists.")
        }
        return iAccount.save(account)
    }

    fun deleteAccount(account: Account) {
        if (!iAccount.findById(account.id).isPresent ){
            throw IllegalArgumentException("Account ${account.username} doesn't exists.")
        }
        return iAccount.delete(account)
    }


}
