package com.takehomettb.inventory_service.service

import com.takehomettb.inventory_service.entity.Food
import com.takehomettb.inventory_service.entity.ReturnStatus
import com.takehomettb.inventory_service.repository.FoodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class FoodService {
    @Autowired lateinit var foodRepository: FoodRepository

    fun getAllFoods(): List<Food> = foodRepository.findAll()

    fun getFoodById(id: Int): Any {
        return foodRepository.findById(id).orElse(null) ?: mapOf(
            "status" to false,
            "message" to "ไม่มีอาหารรายการนี้"
        )
    }

    fun createFood(food: Food): Any {
        if(food.name.isNullOrEmpty()) {
            return mapOf(
                "status" to false,
                "message" to "กรุณากรอกชื่อเมนูอาหาร"
            )
        }
        if(food.price == null) {
            return mapOf(
                "status" to false,
                "message" to "กรุณากรอกราคาเมนูอาหาร"
            )
        }
        return foodRepository.save(food)

    }

    fun updateFood(id: Int, food: Food): Any {
        var result: Food = foodRepository.findById(id).orElse(null)
            ?: return ReturnStatus(
                status = false,
                message = "ไม่มีหมายเลขอาหารนี้"
            )
        if (!food.name.isNullOrBlank()) {
            result.name = food.name
        }
        if (food.price != null) {
            result.price = food.price
        }
        try {
            result.updatedAt = LocalDateTime.now()
            result = foodRepository.save(result)
            return ReturnStatus(
                status = true,
                data = result,
                message = "อัปเดตรายการอาหารเรียบร้อยแล้ว"
            )
        }catch (e: Exception) {
            return ReturnStatus(
                status = false,
                message = "มีข้อผิดพลาดเกิดขึ้น"
            )
        }
    }

    fun deleteFood(id: Int): Any {
        val result: Food = foodRepository.findById(id).orElse(null)
            ?: return ReturnStatus(
                status = false,
                message = "ไม่มีหมายเลขอาหารนี้"
            )
        try {
            foodRepository.delete(result)
            return ReturnStatus(
                status = true,
                message = "ลบรายการอาหารเรียบร้อยแล้ว"
            )
        }catch (e: Exception) {
            return ReturnStatus(
                status = false,
                message = "มีข้อผิดพลาดเกิดขึ้น"
            )
        }
    }

}