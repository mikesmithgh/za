package com.github.mikesmithgh.za.services

import com.github.mikesmithgh.za.models.UserModel
import com.github.mikesmithgh.za.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val db: UserRepository) {
    fun getUsers(): List<UserModel> = db.getUsers()
    fun addUser(user: UserModel): UserModel = db.save(user)
}
