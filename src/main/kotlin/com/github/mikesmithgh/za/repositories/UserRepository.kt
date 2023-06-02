package com.github.mikesmithgh.za.repositories

import com.github.mikesmithgh.za.models.UserModel
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository : CrudRepository<UserModel, Int> {

    @Query("select id, email::text from users")
    fun getUsers(): List<UserModel>

    @Query("select id, email::text from users where email = :email")
    fun getUserByEmail(@Param("email") email: String): List<UserModel>

    @Modifying
    @Query(value = "insert into users (email) VALUES (:email) on conflict do nothing") // ignore if entry already exists
    fun saveIgnoreExists(email: String)

}
