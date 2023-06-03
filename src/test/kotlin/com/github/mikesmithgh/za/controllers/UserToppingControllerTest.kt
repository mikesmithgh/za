package com.github.mikesmithgh.za.controllers

import com.github.mikesmithgh.za.models.UserToppingCountModel
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
class UserToppingControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var toppingService: ToppingService

    @MockkBean
    lateinit var userService: UserService

    @MockkBean
    lateinit var userToppingService: UserToppingService

    val toppingCount1 = UserToppingCountModel("mushroom", 4)
    val toppingCount2 = UserToppingCountModel("bananas", 0)
    val allToppingCounts = listOf(toppingCount1, toppingCount2)

    @Test
    fun `should return multiple topping counts`() {
        every { userToppingService.getUserToppingCount() } returns allToppingCounts;

        mockMvc.perform(get("/usertoppings"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.[0].count").value(4))
            .andExpect(jsonPath("$.[0].topping").value("mushroom"))
            .andExpect(jsonPath("$.[1].count").value(0))
            .andExpect(jsonPath("$.[1].topping").value("bananas"))
    }

    @Test
    fun `should return an empty array if no toppings exist`() {
        every { userToppingService.getUserToppingCount() } returns emptyList();

        mockMvc.perform(get("/usertoppings"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isEmpty())
    }
}
