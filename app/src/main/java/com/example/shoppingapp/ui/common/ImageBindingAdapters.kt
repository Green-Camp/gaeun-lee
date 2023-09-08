package com.example.shoppingapp.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.shoppingapp.GlideApp

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    GlideApp.with(view).load(imageUrl).into(view)
}
