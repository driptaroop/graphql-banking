package org.dripto.banking.graphql.aggregator.controller.models

import java.util.UUID

class Customer(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String
)