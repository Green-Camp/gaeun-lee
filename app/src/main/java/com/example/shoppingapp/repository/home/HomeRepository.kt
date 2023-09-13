package com.example.shoppingapp.repository.home

import com.example.shoppingapp.model.HomeData
import com.example.shoppingapp.repository.home.HomeDataSource

class HomeRepository(private val assetDataSource: HomeDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}