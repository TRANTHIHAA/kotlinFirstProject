package com.example.kotlin.datasource

import com.example.kotlin.model.dto.AddAccount
import com.example.kotlin.model.dto.UpdateAccount
import com.example.kotlin.model.dto.ViewAccount
import org.springframework.http.ResponseEntity

interface AccountResource {

    fun findById(id:Long): ResponseEntity<ViewAccount?>

    fun findAll(): ResponseEntity<Iterable<ViewAccount>>

    fun save(addAccount: AddAccount): ResponseEntity<ViewAccount>

    fun update(updateAccount: UpdateAccount): ResponseEntity<ViewAccount>

    fun deleteById(id:Long): ResponseEntity<Unit>
}
