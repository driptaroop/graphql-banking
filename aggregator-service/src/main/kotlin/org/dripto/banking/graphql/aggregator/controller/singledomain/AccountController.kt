package org.dripto.banking.graphql.aggregator.controller.singledomain

import org.dripto.banking.graphql.aggregator.Constants.ACCOUNT_SERVICE
import org.dripto.banking.graphql.aggregator.controller.models.Account
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Controller
class AccountController(private val restTemplate: RestTemplate) {
    @QueryMapping
    fun getAccounts(): List<Account> = restTemplate.getForObject("http://$ACCOUNT_SERVICE/accounts")

    @QueryMapping
    fun getAccountById(@Argument accountId: String): Account? =
        restTemplate.getForObject("http://$ACCOUNT_SERVICE/accounts/${accountId}")
}