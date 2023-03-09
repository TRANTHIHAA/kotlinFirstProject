package com.example.kotlin.datasource

import com.example.kotlin.model.Account
import com.example.kotlin.model.ViewAccount
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IAccount: CrudRepository<Account, Long> {

     fun findByUsernameAndPassword(userName: String?,passWord: String?): Optional<Account?>

     fun findByEmail(email: String?): Optional<Account?>



}