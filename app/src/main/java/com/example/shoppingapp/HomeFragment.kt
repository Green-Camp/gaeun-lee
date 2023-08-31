package com.example.shoppingapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import org.json.JSONObject

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        val assetLoader = AssetLoader()
        val homeData = assetLoader.getJsonString(requireContext(), "home.json")
        Log.d("homeData", homeData ?: "")

        if (!homeData.isNullOrEmpty()) {
            val jsonObject = JSONObject(homeData)
            val title = jsonObject.getJSONObject("title")
            val text = title.getString("text")
            val iconUrl = title.getString("icon_url")
            val titleValue = Title(text, iconUrl)

            toolbarTitle.text = titleValue.text
            GlideApp.with(this).load(titleValue.iconUrl).into(toolbarIcon)

            val topBanners = jsonObject.getJSONArray("top_banners")
            val size = topBanners.length()
            for (index in 0 until size) {
                val bannerObject = topBanners.getJSONObject(index)
                val backgroundImageUrl = bannerObject.getString("background_image_url")
                val badgeObject = bannerObject.getJSONObject("badge")
                val badgeLabel = badgeObject.getString("label")
                val badgeBackgroundColor = badgeObject.getString("background_color")
                val bannerBadge = BannerBadge(badgeLabel, badgeBackgroundColor)
            }

//            viewpager.adapter = HomeBannerAdapter().apply {
//                submitList()
//            }
        }
    }
}
