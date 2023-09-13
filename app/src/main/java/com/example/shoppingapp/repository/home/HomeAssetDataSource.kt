package com.example.shoppingapp.repository.home

import com.example.shoppingapp.AssetLoader
import com.example.shoppingapp.model.HomeData
import com.google.gson.Gson

class HomeAssetDataSource(private val assetLoader: AssetLoader) : HomeDataSource {

    private val gson = Gson()

    override fun getHomeData(): HomeData? {
        // getJsonString이 nullable이므로, 반환 타입이 null인 경우에는 ui를 그릴 때 데이터가 없음을
        // 안내해주는 편이 낫기 때문에 반환 타입이 nullable인게 좋다.

        return assetLoader.getJsonString("home.json").let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}
