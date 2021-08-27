package com.arvind.nikeshop.model

import java.io.Serializable

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val isliked: Int,
    val imageID: Int,
    val category: String,
) : Serializable
