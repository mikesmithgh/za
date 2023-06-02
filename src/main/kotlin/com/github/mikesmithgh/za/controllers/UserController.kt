package com.github.mikesmithgh.za.controllers

import com.github.mikesmithgh.za.models.UserModel
import com.github.mikesmithgh.za.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val service: UserService) {

    @GetMapping("/user")
    fun getUsers(): List<UserModel> = service.getUsers()

    @PostMapping("/user")
    fun addUser(@RequestBody user: UserModel) = service.addUser(user)

}

