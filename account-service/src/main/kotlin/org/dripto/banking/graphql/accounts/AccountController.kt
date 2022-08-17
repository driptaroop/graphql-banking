package org.dripto.banking.graphql.accounts

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/accounts")
class AccountController {
    @GetMapping
    fun accounts(@RequestParam(name = "customer") customer: UUID? = null): List<Account> = if (customer != null) dataSource.filter { it.customerId == customer } else dataSource

    @GetMapping("/{id}")
    fun account(@PathVariable id: UUID): Account? = dataSource.firstOrNull { it.id == id }

    @GetMapping("/iban/{iban}")
    fun accountByIban(@PathVariable iban: String): Account? = dataSource.firstOrNull { it.iban == iban }
}