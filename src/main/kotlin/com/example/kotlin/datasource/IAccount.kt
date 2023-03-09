package com.example.kotlin.datasource

import com.example.kotlin.model.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IAccount: CrudRepository<Account, Long>
