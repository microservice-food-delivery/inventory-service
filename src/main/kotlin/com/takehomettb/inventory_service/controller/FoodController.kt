package com.takehomettb.inventory_service.controller

import com.takehomettb.inventory_service.entity.Food
import com.takehomettb.inventory_service.service.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/api/inventory")
class FoodController {
    @Autowired lateinit var foodService: FoodService

    @GetMapping("/getFoods")
    fun getAllInventory(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(foodService.getAllFoods())
    }

    @GetMapping("/getFood/{foodId}")
    fun getFoodById(@PathVariable foodId: String): ResponseEntity<Any> {
        return ResponseEntity.ok().body(foodService.getFoodById(Integer.parseInt(foodId)))
    }

    @PostMapping("/createFood")
    fun createFood(@RequestBody food: Food): ResponseEntity<Any> {
        return ResponseEntity.ok().body(foodService.createFood(food))
    }

    @PutMapping("/updateFood/{foodId}")
    fun updateFood(@PathVariable foodId: Int, @RequestBody food: Food): ResponseEntity<Any> {
        return ResponseEntity.ok().body(foodService.updateFood(foodId, food))
    }

//    @DeleteMapping("/food/{foodId}")
//    fun deleteFood(@PathVariable foodId: Int): ResponseEntity<Any> {
//        return ResponseEntity.ok().body(foodService.deleteFood(foodId))
//    }
}