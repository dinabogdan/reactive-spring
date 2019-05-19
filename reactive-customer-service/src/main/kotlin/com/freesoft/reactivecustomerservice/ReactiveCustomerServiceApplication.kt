package com.freesoft.reactivecustomerservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveCustomerServiceApplication

fun main(args: Array<String>) {
	runApplication<ReactiveCustomerServiceApplication>(*args)
}
