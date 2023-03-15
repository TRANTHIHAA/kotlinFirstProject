package com.example.kotlin.datasource

import com.example.kotlin.model.entity.Account
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.io.Serializable
import java.util.*

@Repository
interface IAccount: CrudRepository<Account, Serializable> {

    fun findByUsernameAndPassword(userName: String?,passWord: String?): Optional<Account?>

    fun findByEmail(email: String?): Optional<Account?>



    @Procedure(name = "myTestCallProcedure")
    @Transactional
    fun upsert(@Param("p_username") p_username: String?
               , @Param("p_password") p_password: String?
               , @Param("p_email") p_email: String?
               , @Param("p_bank_id") p_bank_id: Long?
               , @Param("v_result") v_result: Int?
    ): Account



//    @Query(nativeQuery = true, value = """
//select top 1 value from my_table
//where my_fk_id=1 and date <= :date
//order by date desc
//""")
//    fun create(@Param("date") date: Date): BigDecimal?

}

