package com.example.kotlin.controller

import com.example.kotlin.model.Account
import com.example.kotlin.service.IAccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController(private val service: IAccountService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun findAll(): Iterable<Account> = service.findAll()

//    @GetMapping("/{accountNumber}")
//    fun getBank(@PathVariable accountNumber: String): Bank = service.getBank(accountNumber)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody account: Account): Account = service.createAccount(account)

    @PatchMapping
    fun updateBank(@RequestBody account: Account): Account = service.editAccount(account)

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBank(@RequestBody account: Account): Unit = service.deleteAccount(account)
}
