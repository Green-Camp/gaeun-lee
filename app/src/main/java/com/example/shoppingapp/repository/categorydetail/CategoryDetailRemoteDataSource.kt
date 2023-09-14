package com.example.shoppingapp.repository.categorydetail

import com.example.shoppingapp.model.CategoryDetail
import com.example.shoppingapp.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient) : CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}
