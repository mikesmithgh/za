package com.github.mikesmithgh.za.repositories

import com.github.mikesmithgh.za.models.UserToppingCountModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface UserToppingRepository : CrudRepository<UserToppingCountModel, Integer> {

    @Query("select topping::varchar, count from user_count_by_topping")
    fun getUserToppingCount(): List<UserToppingCountModel>

}