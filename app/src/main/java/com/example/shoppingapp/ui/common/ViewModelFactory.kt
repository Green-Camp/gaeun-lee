package com.example.shoppingapp.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingapp.AssetLoader
import com.example.shoppingapp.network.ApiClient
import com.example.shoppingapp.repository.category.CategoryRemoteDataSource
import com.example.shoppingapp.repository.category.CategoryRepository
import com.example.shoppingapp.repository.categorydetail.CategoryDetailRemoteDataSource
import com.example.shoppingapp.repository.categorydetail.CategoryDetailRepository
import com.example.shoppingapp.repository.home.HomeAssetDataSource
import com.example.shoppingapp.repository.home.HomeRepository
import com.example.shoppingapp.ui.category.CategoryViewModel
import com.example.shoppingapp.ui.categorydetail.CategoryDetailViewModel
import com.example.shoppingapp.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }

            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }

            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository =
                    CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))
                CategoryDetailViewModel(repository) as T
            }

            else -> {
                throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}
