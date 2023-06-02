package com.github.mikesmithgh.za.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "users")
data class UserModel(@Id val id: Long? = null, val email: String)
