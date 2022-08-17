package org.dripto.banking.graphql.transactions

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class Transaction(
    val id: UUID,
    val amount: BigDecimal,
    val date: LocalDateTime,
    val account: UUID
)

val dataSource = listOf(
    Transaction(
        id = UUID.fromString("a0244aa7-3a81-4ad6-b800-8b63522d2171"),
        amount = 31.23.toBigDecimal(),
        date = LocalDateTime.now(),
        account = UUID.fromString("2e7a7e62-10fe-4d42-8806-889e7e7a1fa4")
    ),
    Transaction(
        id = UUID.fromString("2a8a0435-cc6b-40f7-af4b-5a4280102527"),
        amount = (-98.00).toBigDecimal(),
        date = LocalDateTime.now(),
        account = UUID.fromString("2e7a7e62-10fe-4d42-8806-889e7e7a1fa4")
    ),
    Transaction(
        id = UUID.fromString("d2414ca3-8589-4e6f-badf-fc0a3ef63228"),
        amount = 0.10.toBigDecimal(),
        date = LocalDateTime.now(),
        account = UUID.fromString("8709814d-33a9-481d-b197-c5f6c5f31abf")
    ),
    Transaction(
        id = UUID.fromString("3fd9f0e0-bca6-4781-8f5a-78e5a907dad5"),
        amount = (-0.87).toBigDecimal(),
        date = LocalDateTime.now(),
        account = UUID.fromString("8709814d-33a9-481d-b197-c5f6c5f31abf")
    ),
)