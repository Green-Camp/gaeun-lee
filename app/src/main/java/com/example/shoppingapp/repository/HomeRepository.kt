package com.example.shoppingapp.repository

import com.example.shoppingapp.model.HomeData

class HomeRepository(private val assetDataSource: HomeDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}