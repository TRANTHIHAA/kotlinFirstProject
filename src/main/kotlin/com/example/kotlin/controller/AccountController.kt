package com.example.kotlin.controller

import com.example.kotlin.datasource.IAccount
import com.example.kotlin.model.Account
import com.example.kotlin.model.Bank
import com.example.kotlin.model.ViewAccount
import com.example.kotlin.model.toView
import com.example.kotlin.service.IAccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController(
    val iAccountService: IAccountService
) {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun findAll(): Iterable<ViewAccount> =
        iAccountService.findAll()

    @PostMapping
    fun createAccount(@RequestBody account: Account): Account {
        return iAccountService.createAccount(account)
    }

    @PatchMapping
    fun editAccount(@RequestBody account: Account): Account {
        return iAccountService.editAccount(account)
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBank(@RequestBody account: Account): Unit = iAccountService.deleteAccount(account)


}
