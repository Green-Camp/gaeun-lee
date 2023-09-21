package com.example.shoppingapp.repository.cart

import com.example.shoppingapp.model.CartItem

interface CartItemDataSource {

    suspend fun addCartItem(cartItem: CartItem)

    suspend fun getCartItems(): List<CartItem>
}
