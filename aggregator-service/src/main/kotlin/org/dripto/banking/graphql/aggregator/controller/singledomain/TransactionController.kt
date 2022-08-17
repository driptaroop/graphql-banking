package org.dripto.banking.graphql.aggregator.controller.singledomain

import org.dripto.banking.graphql.aggregator.Constants.TRANSACTION_SERVICE
import org.dripto.banking.graphql.aggregator.controller.models.Transaction
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Controller
class TransactionController(
    private val restTemplate: RestTemplate
) {
    @QueryMapping
    fun getTransactions(): List<Transaction> = restTemplate.getForObject("http://$TRANSACTION_SERVICE/transactions")

    @QueryMapping
    fun getTransactionsById(@Argument transactionId: String): Transaction? = restTemplate.getForObject("http://$TRANSACTION_SERVICE/transactions/$transactionId")
}