package com.example.shoppingapp.kotlin.screen

import com.example.shoppingapp.kotlin.data.Product

class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식"),
    )
    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }

    fun showProduct(selectedCategory: String) {
        val categoryProduct = categories[selectedCategory]
        if (!categoryProduct.isNullOrEmpty()) {
            println(
                """
                ***======================================***
                선택하신 [$selectedCategory] 카테고리 상품입니다.
                """.trimIndent(),
            )
            val productSize = categoryProduct.size
            for (index in 0 until productSize) {
                println("$index. ${categoryProduct[index].name}")
            }
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전입니다.")
    }
}
