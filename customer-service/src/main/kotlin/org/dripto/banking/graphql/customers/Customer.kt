package org.dripto.banking.graphql.customers

import java.util.UUID

data class Customer(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String
)

val dataSource = listOf(
    Customer(
        id = UUID.fromString("669fe89d-acf5-4caa-9288-92221536bcfc"),
        firstName = "Harry",
        lastName = "Potter",
        email = "harry.potter@dkb.de"
    )
)