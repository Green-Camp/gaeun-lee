package com.example.shoppingapp.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingapp.AssetLoader
import com.example.shoppingapp.network.ApiClient
import com.example.shoppingapp.repository.CategoryRemoteDataSource
import com.example.shoppingapp.repository.CategoryRepository
import com.example.shoppingapp.repository.HomeAssetDataSource
import com.example.shoppingapp.repository.HomeRepository
import com.example.shoppingapp.ui.category.CategoryViewModel
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

            else -> {
                throw java.lang.IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}
