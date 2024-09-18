package com.takehomettb.inventory_service.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "food_inventory")
data class Food(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    var foodId: Int? = null,

    @Column(name = "name", nullable = true)
    var name: String? = null,

    @Column(name = "price", nullable = true)
    var price: BigDecimal? = null,

    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = LocalDateTime.now(),
)
