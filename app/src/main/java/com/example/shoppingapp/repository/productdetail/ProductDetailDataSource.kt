package com.example.shoppingapp.repository.productdetail

import com.example.shoppingapp.model.Product

interface ProductDetailDataSource {

    suspend fun getProductDetail(productId: String): Product
}
