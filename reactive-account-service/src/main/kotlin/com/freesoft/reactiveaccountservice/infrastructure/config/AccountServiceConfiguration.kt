package com.freesoft.reactiveaccountservice.infrastructure.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate

@Configuration
data class AccountServiceConfiguration(private val configurationProperties: AccountServiceConfigurationProperties) {

    @Bean
    fun mongoClient(): MongoClient = MongoClients.create(configurationProperties.dbUrl)

    @Bean
    fun reactiveMongoTemplate() = ReactiveMongoTemplate(mongoClient(), configurationProperties.dbName)
}