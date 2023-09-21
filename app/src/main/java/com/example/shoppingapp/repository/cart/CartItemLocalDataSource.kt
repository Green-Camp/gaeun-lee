package com.example.shoppingapp.repository.cart

import com.example.shoppingapp.database.CartItemDao
import com.example.shoppingapp.model.CartItem

class CartItemLocalDataSource(private val dao: CartItemDao) : CartItemDataSource {
    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }
}
