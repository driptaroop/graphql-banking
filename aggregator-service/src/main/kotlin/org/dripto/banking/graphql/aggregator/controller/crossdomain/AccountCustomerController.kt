package org.dripto.banking.graphql.aggregator.controller.crossdomain

import graphql.schema.DataFetchingEnvironment
import org.dripto.banking.graphql.aggregator.Constants
import org.dripto.banking.graphql.aggregator.controller.models.Account
import org.dripto.banking.graphql.aggregator.controller.models.Customer
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Controller
class AccountCustomerController(private val restTemplate: RestTemplate) {
    @SchemaMapping(typeName = "Account", field = "customer")
    fun getCustomerFromAccount(dfe: DataFetchingEnvironment): Customer? {
        val customerId: String = when(val source = dfe.getSource<Any>()) {
            is Account -> source.customerId.toString()
            is Map<*, *> -> source["customerId"] as String
            else -> throw IllegalStateException("should not occur")
        }
        return restTemplate.getForObject("http://${Constants.CUSTOMER_SERVICE}/customers/$customerId")
    }

    @SchemaMapping(typeName = "Customer", field = "accounts")
    fun getAccountFromCustomer(dfe: DataFetchingEnvironment): List<Account> {
        val customerId: String = when(val source = dfe.getSource<Any>()) {
            is Customer -> source.id.toString()
            is Map<*, *> -> source["id"] as String
            else -> throw IllegalStateException("should not occur")
        }
        return restTemplate.getForObject("http://${Constants.ACCOUNT_SERVICE}/accounts?customer=${customerId}")
    }
}