package com.example.shoppingapp.repository

import com.example.shoppingapp.model.Category

interface CategoryDatasource {

    suspend fun getCategories(): List<Category>
}
