package org.dripto.banking.graphql.aggregator.controller.models

import java.math.BigDecimal
import java.util.UUID

class Account(
    val id: UUID,
    val type: AccountType,
    val iban: String,
    val balance: BigDecimal,
    val customerId: UUID
) {
    enum class AccountType { SAVINGS, CURRENT }
}