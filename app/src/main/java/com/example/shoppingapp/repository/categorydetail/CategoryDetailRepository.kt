package com.example.shoppingapp.repository.categorydetail

import com.example.shoppingapp.model.CategoryDetail

class CategoryDetailRepository(private val remoteDataSource: CategoryDetailRemoteDataSource) {

    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}