package com.example.shoppingapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.Banner
import com.example.shoppingapp.Title

class HomeViewModel : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanner: LiveData<List<Banner>> = _topBanners

    fun loadHomeData() {
        // TODO Data Layer - Repository에 요청
    }
}
