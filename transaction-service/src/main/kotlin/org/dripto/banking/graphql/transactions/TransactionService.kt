package org.dripto.banking.graphql.transactions

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TransactionService

fun main(args: Array<String>) {
    runApplication<TransactionService>(*args)
}