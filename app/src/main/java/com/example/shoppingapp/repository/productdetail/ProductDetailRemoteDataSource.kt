package com.example.shoppingapp.repository.productdetail

import com.example.shoppingapp.model.Product
import com.example.shoppingapp.network.ApiClient

class ProductDetailRemoteDataSource(private val api: ApiClient) : ProductDetailDataSource {
    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}
