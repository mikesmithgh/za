package com.github.mikesmithgh.za

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ZaApplication

fun main(args: Array<String>) {
    runApplication<ZaApplication>(*args)
}


@RestController
class MessageResource {

    @GetMapping
    fun index(): List<Message> = listOf(
        Message("1", "hello!"),
        Message("2", "hi!")
    )

}


data class Message(val id: String?, val text: String)
