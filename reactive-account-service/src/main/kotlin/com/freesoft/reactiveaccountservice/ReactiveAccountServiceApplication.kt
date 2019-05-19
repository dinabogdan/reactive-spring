package com.freesoft.reactiveaccountservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [MongoAutoConfiguration::class, MongoDataAutoConfiguration::class])
class ReactiveAccountServiceApplication

fun main(args: Array<String>) {
	runApplication<ReactiveAccountServiceApplication>(*args)
}
