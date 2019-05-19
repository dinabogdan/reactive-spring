package com.freesoft.reactiveaccountservice.api.controller

import com.freesoft.reactiveaccountservice.api.model.AccountDTO
import com.freesoft.reactiveaccountservice.domain.Account
import com.freesoft.reactiveaccountservice.domain.AccountRepository
import org.reactivestreams.Publisher
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
data class AccountController(private val accountRepository: AccountRepository) {

    @GetMapping("/accounts/customers/{customer}")
    fun findByCustomer(@PathVariable("customer") customerId: String) =
            accountRepository.findByCustomerId(customerId).mapToAccountDTO(outgoingMapper)


    @GetMapping("/accounts")
    fun findAll() = accountRepository.findAll().mapToAccountDTO(outgoingMapper)

    @GetMapping("/accounts/{id}")
    fun findAccountById(@PathVariable("id") id: Int) =
            accountRepository.findById(id).mapToAccountDTO(outgoingMapper)

    @PostMapping("/persons")
    fun createAccount(@RequestBody accountStream: Publisher<AccountDTO>) =
            accountRepository.save(Mono.from(accountStream).mapToAccount(incomingMapper))

    val outgoingMapper: (Account) -> AccountDTO = {
        AccountDTO.Builder()
                .id(it.id)
                .number(it.number)
                .customerId(it.customerId)
                .amount(it.amount)
                .build()
    }

    val incomingMapper: (AccountDTO) -> Account = {
        Account.Builder()
                .id(it.id)
                .number(it.number)
                .customerId(it.customerId)
                .amount(it.amount)
                .build()
    }

    private inline fun Mono<AccountDTO>.mapToAccount(noinline transformer: (AccountDTO) -> Account): Mono<Account> {
        return this.map(transformer)
    }

    private inline fun Mono<Account>.mapToAccountDTO(noinline transformer: (Account) -> AccountDTO): Mono<AccountDTO> {
        return this.map(transformer)
    }

    private inline fun Flux<Account>.mapToAccountDTO(noinline transformer: (Account) -> AccountDTO): Flux<AccountDTO> {
        return this.map(transformer)
    }

}