package com.freesoft.reactiveaccountservice.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Account(@Id val id: String?, val number: String?, val customerId: String?, val amount: Int?) {

    data class Builder(
            var id: String? = null,
            var customerId: String? = null,
            var number: String? = null,
            var amount: Int? = null
    ) {
        fun id(id: String?) = apply { this.id = id }
        fun customerId(customerId: String?) = apply { this.customerId = customerId }
        fun number(number: String?) = apply { this.number = number }
        fun amount(amount: Int?) = apply { this.amount = amount }

        fun build() = Account(id, number, customerId, amount)
    }
}