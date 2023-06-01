package com.github.mikesmithgh.za.controllers

import com.github.mikesmithgh.za.models.UserToppingCountModel
import com.github.mikesmithgh.za.services.UserToppingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserToppingController(val service: UserToppingService) {

    @GetMapping("/usertoppings")
    fun getUserToppings(): List<UserToppingCountModel> = service.getUserToppingCount()

}

