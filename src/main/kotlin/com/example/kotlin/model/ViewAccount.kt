package com.example.kotlin.model

data class ViewAccount(
    val id: Long,
    val username: String,
    val password: String,
    val email: String
)

fun Account.toView() =
    ViewAccount(id,username,password,email)
