package com.github.mikesmithgh.za.controllers

import com.github.mikesmithgh.za.models.ToppingModel
import com.github.mikesmithgh.za.models.UserModel
import com.github.mikesmithgh.za.services.ToppingService
import com.github.mikesmithgh.za.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ToppingController(val service: ToppingService) {

    @GetMapping("/topping")
    fun getToppings(): List<ToppingModel> = service.getToppings()

    @PostMapping("/topping")
    fun addTopping(@RequestBody topping: ToppingModel): ToppingModel = service.addTopping(topping)
}

