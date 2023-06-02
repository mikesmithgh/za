package com.github.mikesmithgh.za.services

import com.github.mikesmithgh.za.dto.UserToppingsRequest
import com.github.mikesmithgh.za.models.UserToppingCountModel
import com.github.mikesmithgh.za.repositories.UserToppingRepository
import org.springframework.stereotype.Service

@Service
class UserToppingService(
    val db: UserToppingRepository
) {
    fun getUserToppingCount(): List<UserToppingCountModel> = db.getUserToppingCount()

    fun addUserToppings(userToppingsRequest: UserToppingsRequest) =
        db.addUserToppings(userToppingsRequest.email, userToppingsRequest.toppingsToPgArray())
}
