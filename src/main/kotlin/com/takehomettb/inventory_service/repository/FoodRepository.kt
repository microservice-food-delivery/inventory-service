package com.takehomettb.inventory_service.repository

import com.takehomettb.inventory_service.entity.Food
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : JpaRepository<Food, Int> {

    fun findFoodByFoodId(id: Int): Food
}