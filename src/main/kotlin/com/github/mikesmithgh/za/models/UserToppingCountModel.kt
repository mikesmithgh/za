package com.github.mikesmithgh.za.models

import org.springframework.data.relational.core.mapping.Table

@Table(name = "user_count_by_topping")
data class UserToppingCountModel(val topping: String, val count: Int)
