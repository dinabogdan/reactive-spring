package com.freesoft.reactiveaccountservice.domain

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
data class AccountRepository(private val template: ReactiveMongoTemplate) {

    fun findById(id: Int) = template.findById(id, Account::class.java)

    fun findAll() = template.findAll(Account::class.java)

    fun findByCustomerId(customerId: String) = template.find(query(where("customerId").`is`(customerId)),
            Account::class.java)

    fun save(account: Mono<Account>) = template.insert(account)

}