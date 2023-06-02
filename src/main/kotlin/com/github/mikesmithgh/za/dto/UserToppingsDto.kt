package com.github.mikesmithgh.za.dto

data class UserToppingsRequest(
    val email: String,
    val toppings: List<String>
) {
    fun toppingsToPgArray(): String {
        return toppings.joinToString(separator = ",")
    }

}


