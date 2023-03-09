package com.example.kotlin.service

import com.example.kotlin.datasource.IAccount
import com.example.kotlin.model.Account
import com.example.kotlin.model.ViewAccount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IAccountService {
    @Autowired
    lateinit var iAccount: IAccount

    fun findAll(): Iterable<Account> =
        iAccount.findAll()

    fun createAccount(account: Account): Account {
        if (iAccount.findById(account.id).isPresent or
            iAccount.findByUsernameAndPassword(account.username,account.password).isPresent){
            throw IllegalArgumentException("Account ${account.username} already exists.")
        }
        if (iAccount.findByEmail(account.email).isPresent){
            throw IllegalArgumentException("Email ${account.email} already used.")
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