package com.example.shoppingapp.repository

import com.example.shoppingapp.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}
