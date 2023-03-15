package com.example.kotlin.service

import com.example.kotlin.datasource.IAccount
import com.example.kotlin.model.dto.AddAccount
import com.example.kotlin.model.dto.UpdateAccount
import com.example.kotlin.model.dto.ViewAccount
import com.example.kotlin.model.entity.Account
import com.example.kotlin.transformer.AddAccountRequestTransformer
import com.example.kotlin.transformer.toAccountResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AccountManagementServiceImpl(private val iAccount: IAccount,
                                   private val addPersonRequestTransformer: AddAccountRequestTransformer
                                    ) : AccountManagementService {
    override fun findById(id: Long): ViewAccount? {
       return this.findAccountById(id).toAccountResponse()
    }

    override fun findAll():Iterable<ViewAccount> {
       return this.iAccount.findAll().map(Account :: toAccountResponse)
    }

    override fun save(addAccountRequest: AddAccount): ViewAccount {
        return this.saveOrUpdate(addPersonRequestTransformer.transform(addAccountRequest))
    }

    override fun update(updateAccountRequest: UpdateAccount): ViewAccount {
        val account = this.findAccountById(updateAccountRequest.id) ?: throw IllegalStateException("${updateAccountRequest.id} not found")
        return this.saveOrUpdate(account.apply {
            this.username = updateAccountRequest.username?: ""
            this.password = updateAccountRequest.password?: ""
            this.email = updateAccountRequest.email?: ""
            this.bank = updateAccountRequest.bank
        })
    }

    override fun deleteById(id: Long) {
        this.iAccount.deleteById(id)
    }

    private fun findAccountById(id: Long): Account? = this.iAccount.findByIdOrNull(id)

    private fun saveOrUpdate(account: Account): ViewAccount = this.iAccount.save(account).toAccountResponse()
}
