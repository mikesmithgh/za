package com.github.mikesmithgh.za.repositories

import com.github.mikesmithgh.za.models.ToppingModel
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ToppingRepository : CrudRepository<ToppingModel, Integer> {

    @Query("select id, name::varchar from toppings")
    fun getToppings(): List<ToppingModel>

}