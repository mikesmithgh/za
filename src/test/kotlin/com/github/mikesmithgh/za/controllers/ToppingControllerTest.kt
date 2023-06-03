package com.github.mikesmithgh.za.controllers

import com.github.mikesmithgh.za.models.ToppingModel
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
class ToppingControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var toppingService: ToppingService

    @MockkBean
    lateinit var userService: UserService

    @MockkBean
    lateinit var userToppingService: UserToppingService

    val topping1 = ToppingModel(1, "pineapple")
    val topping2 = ToppingModel(2, "ham")
    val allToppings = listOf(topping1, topping2)

    @Test
    fun `should return multiple toppings`() {
        every { toppingService.getToppings() } returns allToppings;

        mockMvc.perform(get("/topping"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.[0].id").value(1))
            .andExpect(jsonPath("$.[0].name").value("pineapple"))
            .andExpect(jsonPath("$.[1].id").value(2))
            .andExpect(jsonPath("$.[1].name").value("ham"))
    }

    @Test
    fun `should return an empty array if no toppings exist`() {
        every { toppingService.getToppings() } returns emptyList();

        mockMvc.perform(get("/topping"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isEmpty())
    }
}
