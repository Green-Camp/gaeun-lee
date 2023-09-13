package com.example.shoppingapp.repository.category

import com.example.shoppingapp.model.Category
import com.example.shoppingapp.network.ApiClient
import com.example.shoppingapp.repository.category.CategoryDatasource

class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDatasource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}