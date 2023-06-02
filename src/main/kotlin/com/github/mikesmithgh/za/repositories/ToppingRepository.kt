package com.github.mikesmithgh.za.repositories

import com.github.mikesmithgh.za.models.ToppingModel
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ToppingRepository : CrudRepository<ToppingModel, Int> {

    @Query("select id, name::text from toppings")
    fun getToppings(): List<ToppingModel>

    @Modifying
    @Query(value = "insert into toppings (name) VALUES (:topping) on conflict do nothing ") // ignore if entry already exists
    fun saveIgnoreExists(@Param("topping") topping: String)
}
