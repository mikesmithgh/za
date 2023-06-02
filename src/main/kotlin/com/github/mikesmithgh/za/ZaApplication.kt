package com.github.mikesmithgh.za

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZaApplication

fun main(args: Array<String>) {
    runApplication<ZaApplication>(*args)
}
