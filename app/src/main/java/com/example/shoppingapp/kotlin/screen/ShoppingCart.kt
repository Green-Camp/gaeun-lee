package com.example.shoppingapp.kotlin.screen

import com.example.shoppingapp.kotlin.LINE_DIVIDER
import com.example.shoppingapp.kotlin.data.CartItems
import com.example.shoppingapp.kotlin.extensions.getNotEmptyString

class ShoppingCart : Screen() {
    private val products = CartItems.products

    fun showCartItems() {
        ScreenStack.push(this)
        if (products.isNotEmpty()) {
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                    $LINE_DIVIDER
                    장바구니에 담은 상품 목록 입니다.
                    
                    """.trimIndent(),
                ) { product ->
                    "카테고리: ${product.categoryLabel} / 상품명: ${product.name} / 수량: ${products[product]}"
                },
            )
            showPreviousScreenOption()
        } else {
            println(
                """
                장바구니에 담긴 상품이 없습니다.
                """.trimIndent(),
            )
        }
    }

    private fun showPreviousScreenOption() {
        println(
            """
                $LINE_DIVIDER
                이전 화면으로 돌아가시겠습니까? (y/n)
            """.trimIndent(),
        )
        when (readLine().getNotEmptyString()) {
            "y" -> {
                moveToPreviousScreen()
            }
            "n" -> {
                showCartItems()
            }
            else -> {
                // TODO 재입력 요청청
            }
        }
    }

    private fun moveToPreviousScreen(){
        ScreenStack.pop()
        when (val previousScreen = ScreenStack.peek()){
            is ShoppingCategory -> {
                previousScreen.showCategories()
            }
            is ShoppingProductList -> {
                previousScreen.showProducts()
            }
            is ShoppingCart, is ShoppingHome -> {
                // 아무 것도 하지 않음
            }
            else -> {}
        }
    }
}
