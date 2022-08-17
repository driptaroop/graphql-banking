package org.dripto.banking.graphql.transactions

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/transactions")
class TransactionController {
    @GetMapping
    fun transactions(@RequestParam(name = "account") account: UUID? = null): List<Transaction> = if (account != null) dataSource.filter { it.account == account } else dataSource

    @GetMapping("/{id}")
    fun transaction(@PathVariable id: UUID): Transaction? = dataSource.singleOrNull{ it.id == id }
}