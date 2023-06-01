package com.github.mikesmithgh.za

import com.github.mikesmithgh.za.services.UserToppingService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.relational.core.mapping.Table
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ZaApplication

fun main(args: Array<String>) {
    runApplication<ZaApplication>(*args)
}
