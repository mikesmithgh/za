package com.github.mikesmithgh.za.models

import org.springframework.data.relational.core.mapping.Table

@Table(name = "user_topping")
data class UserToppingIDModel(val user_id: Long, val topping_id: Long)

data class UserToppingModel(val user_id: Long, val user_email: String, val topping_id: Long, val topping_name: String)
