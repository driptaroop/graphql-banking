package org.dripto.banking.graphql.aggregator.controller.models

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

class Transaction(
    val id: UUID,
    val amount: BigDecimal,
    val date: LocalDateTime,
    val accountId: UUID
)