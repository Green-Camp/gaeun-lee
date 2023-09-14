package com.example.shoppingapp.repository.categorydetail

import com.example.shoppingapp.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}
