package com.example.shoppingapp.repository

import com.example.shoppingapp.HomeData

class HomeRepository(private val assetDataSource: HomeDataSource) {

    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}