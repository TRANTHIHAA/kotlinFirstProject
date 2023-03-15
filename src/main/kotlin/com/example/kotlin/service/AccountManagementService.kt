package com.example.kotlin.service

import com.example.kotlin.model.dto.AddAccount
import com.example.kotlin.model.dto.UpdateAccount
import com.example.kotlin.model.dto.ViewAccount
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface AccountManagementService {

    fun findById(id:Long): ViewAccount?

    fun findAll(): Iterable<ViewAccount>

    fun save(addAccountRequest: AddAccount): ViewAccount

    fun update(updateAccountRequest: UpdateAccount): ViewAccount

    fun deleteById(id:Long)
}
