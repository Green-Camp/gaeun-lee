package com.example.shoppingapp.repository

import com.example.shoppingapp.model.Category
import com.example.shoppingapp.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDatasource{
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}