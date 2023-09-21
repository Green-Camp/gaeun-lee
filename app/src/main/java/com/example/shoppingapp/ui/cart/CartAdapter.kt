package com.example.shoppingapp.ui.cart

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.databinding.ItemCartSectionBinding
import com.example.shoppingapp.databinding.ItemCartSectionHeaderBinding
import com.example.shoppingapp.model.CartHeader
import com.example.shoppingapp.model.CartItem
import com.example.shoppingapp.model.CartProduct

private const val VIEW_TYPE_HEADER = 0
private const val VIEW_TYPE_ITEM = 1

class CartAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val cartProducts = mutableListOf<CartProduct>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_HEADER -> HeaderViewHolder(
                ItemCartSectionHeaderBinding.inflate(
                    inflater,
                    parent,
                    false,
                ),
            )

            else -> ItemViewHolder(ItemCartSectionBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return cartProducts.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                val item = cartProducts[position] as CartHeader
                holder.bind(item)
            }

            is ItemViewHolder -> {
                val item = cartProducts[position] as CartItem
                holder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (cartProducts[position]) {
            is CartHeader -> VIEW_TYPE_HEADER
            is CartItem -> VIEW_TYPE_ITEM
        }
    }

    fun submitHeaderAndItemList(items: List<CartItem>) {
        val itemGroup = items.groupBy { it.brandName }
        val products = mutableListOf<CartProduct>()
        val example = mutableListOf<CartProduct>()
        itemGroup.entries.forEach { entry ->
            val header = CartHeader(entry.key)
            products.add(header)
            products.addAll(entry.value)
        }

        itemGroup.forEach { entry ->
            val header = CartHeader(entry.key)
            example.add(header)
            example.addAll(entry.value)
        }

        Log.d("엔트리", "$products")
        Log.d("엔트리 연습", "$example")

        cartProducts.addAll(products)
        notifyItemRangeInserted(cartProducts.size, products.size)
    }

    class HeaderViewHolder(private val binding: ItemCartSectionHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(header: CartHeader) {
            binding.header = header
            binding.executePendingBindings()
        }
    }

    class ItemViewHolder(private val binding: ItemCartSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}
