package org.dripto.banking.graphql.aggregator.controller.singledomain

import org.dripto.banking.graphql.aggregator.Constants.CUSTOMER_SERVICE
import org.dripto.banking.graphql.aggregator.controller.models.Customer
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.util.UUID

@Controller
class CustomerController(
    private val restTemplate: RestTemplate
) {
    @QueryMapping
    fun getCustomers(): List<Customer> = restTemplate.getForObject("http://$CUSTOMER_SERVICE/customers")

    @QueryMapping
    fun getCustomerById(@Argument customerId: UUID): Customer? = restTemplate.getForObject("http://$CUSTOMER_SERVICE/customers/${customerId}")
}