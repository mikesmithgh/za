package com.github.mikesmithgh.za.controllers

import com.github.mikesmithgh.za.models.UserModel
import com.github.mikesmithgh.za.services.ToppingService
import com.github.mikesmithgh.za.services.UserService
import com.github.mikesmithgh.za.services.UserToppingService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class UserControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var toppingService: ToppingService

    @MockkBean
    lateinit var userService: UserService

    @MockkBean
    lateinit var userToppingService: UserToppingService

    val user1 = UserModel(1, "mike@fakeemail.com")
    val user2 = UserModel(2, "bob@fakeemail.com")
    val allUsers = listOf(user1, user2)

    @Test
    fun `should return multiple users`() {
        every { userService.getUsers() } returns allUsers;

        mockMvc.perform(get("/user"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.[0].id").value(1))
            .andExpect(jsonPath("$.[0].email").value("mike@fakeemail.com"))
            .andExpect(jsonPath("$.[1].id").value(2))
            .andExpect(jsonPath("$.[1].email").value("bob@fakeemail.com"))
    }

    @Test
    fun `should return an empty array if no users exist`() {
        every { userService.getUsers() } returns emptyList();

        mockMvc.perform(get("/user"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isEmpty())
    }
}
