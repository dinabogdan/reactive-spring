package com.freesoft.reactiveaccountservice.api.model

data class AccountDTO(val id: String?, val customerId: String?, val number: String?, val amount: Int?) {

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

        fun build() = AccountDTO(id, customerId, number, amount)
    }
}