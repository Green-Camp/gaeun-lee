package com.example.shoppingapp.repository.productdetail

import com.example.shoppingapp.model.Product

class ProductDetailRepository(private val remoteDataSource: ProductDetailRemoteDataSource) :
    ProductDetailDataSource {

    override suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}
