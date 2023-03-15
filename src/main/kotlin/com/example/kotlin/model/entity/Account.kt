package com.example.kotlin.model.entity

import jakarta.persistence.*
import java.util.*

@NamedStoredProcedureQueries(
    NamedStoredProcedureQuery(
        name = "myTestCallProcedure"
        , procedureName = "pkg_test_kotlin.sp_create"
        , parameters = arrayOf(
            StoredProcedureParameter(mode = ParameterMode.IN, name = "p_username", type = String::class),
            StoredProcedureParameter(mode = ParameterMode.IN, name = "p_password", type = String::class),
            StoredProcedureParameter(mode = ParameterMode.IN, name = "p_email", type = String::class),
            StoredProcedureParameter(mode = ParameterMode.IN, name = "p_bank_id", type = Long::class),
            StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "v_result", type = Void::class)
        )
        , resultClasses = [Account::class]
    )
)

//@NamedNativeQueries({
//    NamedNativeQuery(
//        name = "callStockStoreProcedure",
//        query = "CALL GetStocks(:stockCode)",
//        resultClass = Account.class
//
//    )
//
//})


@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    var username: String,
    var password: String,
    var email: String,

    @ManyToOne
    @JoinColumn(name="BANK")
    var bank: Bank?,
) {
    constructor(): this(0, "","","",null)

}


