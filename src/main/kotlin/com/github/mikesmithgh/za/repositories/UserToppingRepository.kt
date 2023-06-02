package com.github.mikesmithgh.za.repositories

import com.github.mikesmithgh.za.models.UserToppingCountModel
import com.github.mikesmithgh.za.models.UserToppingModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface UserToppingRepository : CrudRepository<UserToppingCountModel, Int> {

    @Query("select topping::text, count from user_count_by_topping")
    fun getUserToppingCount(): List<UserToppingCountModel>

    @Query(value = "select user_id, user_email::text, topping_id, topping_name::text from add_user_toppings(:email, :toppings)")
    fun addUserToppings(email: String, toppings: String): List<UserToppingModel>

}
