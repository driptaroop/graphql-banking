package org.dripto.banking.graphql.customers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/customers")
class CustomerController {
    @GetMapping
    fun customers() = dataSource

    @GetMapping("/{id}")
    fun customer(@PathVariable id: UUID) = dataSource.firstOrNull { it.id == id }
}