package org.dripto.banking.graphql.customers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomerService

fun main(args: Array<String>) {
    runApplication<CustomerService>(*args)
}