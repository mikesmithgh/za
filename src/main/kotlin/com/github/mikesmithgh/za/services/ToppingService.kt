package com.github.mikesmithgh.za.services

import com.github.mikesmithgh.za.models.ToppingModel
import com.github.mikesmithgh.za.repositories.ToppingRepository
import org.springframework.stereotype.Service

@Service
class ToppingService(val db: ToppingRepository) {
    fun getToppings(): List<ToppingModel> = db.getToppings()
    fun addTopping(topping: ToppingModel) = db.saveIgnoreExists(topping.name)
}
