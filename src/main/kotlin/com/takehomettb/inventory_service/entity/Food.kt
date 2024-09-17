package com.takehomettb.inventory_service.entity

import jakarta.persistence.*
import java.math.BigDecimal

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
)
