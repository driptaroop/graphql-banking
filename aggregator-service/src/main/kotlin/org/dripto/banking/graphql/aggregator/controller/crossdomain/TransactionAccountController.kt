package org.dripto.banking.graphql.aggregator.controller.crossdomain

import graphql.schema.DataFetchingEnvironment
import org.dripto.banking.graphql.aggregator.Constants
import org.dripto.banking.graphql.aggregator.controller.models.Account
import org.dripto.banking.graphql.aggregator.controller.models.Transaction
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Controller
class TransactionAccountController(
    private val restTemplate: RestTemplate
) {
    @SchemaMapping(typeName = "Transaction", field = "account")
    fun getAccountFromTransaction(dfe: DataFetchingEnvironment): Account {
        val accountId = when(val source = dfe.getSource<Any>()) {
            is Transaction -> source.accountId.toString()
            is LinkedHashMap<*, *> -> source["account"] as String
            else -> throw IllegalStateException("should not occur")
        }
        return restTemplate.getForObject("http://${Constants.ACCOUNT_SERVICE}/accounts/${accountId}")
    }

    @SchemaMapping(typeName = "Account", field = "transactions")
    fun getTransactionFromAccount(dfe: DataFetchingEnvironment): List<Transaction> {
        val accountId = when(val source = dfe.getSource<Any>()) {
            is Account -> source.id.toString()
            is LinkedHashMap<*, *> -> source["id"] as String
            else -> throw IllegalStateException("should not occur")
        }
        return restTemplate.getForObject("http://${Constants.TRANSACTION_SERVICE}/transactions?account=${accountId}")
    }
}