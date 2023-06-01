package com.github.mikesmithgh.za.repositories

import com.github.mikesmithgh.za.models.UserModel
import com.github.mikesmithgh.za.models.UserToppingCountModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserModel, Integer> {

    @Query("select id, email::varchar from users")
    fun getUsers(): List<UserModel>

}