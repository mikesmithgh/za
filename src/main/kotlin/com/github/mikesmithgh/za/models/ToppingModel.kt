package com.github.mikesmithgh.za.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "toppings")
data class ToppingModel(@Id val id: Int, val name: String)
