package com.example.shoppingapp.repository.category

import com.example.shoppingapp.model.Category
import com.example.shoppingapp.repository.category.CategoryRemoteDataSource

class CategoryRepository(private val remoteDatasource: CategoryRemoteDataSource) {

    suspend fun getCategories(): List<Category> {
        return remoteDatasource.getCategories()
    }
}
