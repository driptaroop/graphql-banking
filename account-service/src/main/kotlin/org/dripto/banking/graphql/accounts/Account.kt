package org.dripto.banking.graphql.accounts

import java.math.BigDecimal
import java.util.UUID

data class Account(
    val id: UUID,
    val type: AccountType,
    val iban: String,
    val balance: BigDecimal,
    val customerId: UUID
) {
    enum class AccountType { SAVINGS, CURRENT }
}

val dataSource = listOf(
    Account(
        id = UUID.fromString("2e7a7e62-10fe-4d42-8806-889e7e7a1fa4"),
        type = Account.AccountType.SAVINGS,
        iban = "DE91500105173974927219",
        balance = 10123.toBigDecimal(),
        customerId = UUID.fromString("669fe89d-acf5-4caa-9288-92221536bcfc")
    ),
    Account(
        id = UUID.fromString("8709814d-33a9-481d-b197-c5f6c5f31abf"),
        type = Account.AccountType.SAVINGS,
        iban = "DE50500105177133715497",
        balance = 10123.toBigDecimal(),
        customerId = UUID.fromString("669fe89d-acf5-4caa-9288-92221536bcfc")
    )
)