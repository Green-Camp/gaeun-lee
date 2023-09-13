package com.example.shoppingapp.repository.home

import com.example.shoppingapp.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}
