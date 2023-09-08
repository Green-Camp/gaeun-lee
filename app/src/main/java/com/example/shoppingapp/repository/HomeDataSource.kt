package com.example.shoppingapp.repository

import com.example.shoppingapp.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}
