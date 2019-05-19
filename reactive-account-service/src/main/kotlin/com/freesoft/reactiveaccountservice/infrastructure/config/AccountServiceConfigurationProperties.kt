package com.freesoft.reactiveaccountservice.infrastructure.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "mongo")
class AccountServiceConfigurationProperties {
    lateinit var dbUrl: String
    lateinit var dbName: String
}