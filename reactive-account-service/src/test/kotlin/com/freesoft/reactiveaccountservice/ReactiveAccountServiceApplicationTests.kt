package com.freesoft.reactiveaccountservice

import com.freesoft.reactiveaccountservice.domain.AccountRepository
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ReactiveAccountServiceApplicationTests {

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun contextLoads() {
        assertNotNull(accountRepository)
    }

}
