package com.example.shoppingapp.repository

import com.example.shoppingapp.model.Category

class CategoryRepository(private val remoteDatasource: CategoryRemoteDataSource) {

    suspend fun getCategories(): List<Category> {
        return remoteDatasource.getCategories()
    }
}
