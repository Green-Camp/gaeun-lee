package com.example.shoppingapp.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.databinding.ItemCategoryPromotionBinding
import com.example.shoppingapp.model.Product

class ProductPromotionAdapter :
    ListAdapter<Product, ProductPromotionAdapter.ProductPromotionViewHolder>(ProductDiffCallBack()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProductPromotionViewHolder {
        val binding =
            ItemCategoryPromotionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductPromotionViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductPromotionViewHolder,
        position: Int,
    ) {
        holder.bind(getItem(position))
    }

    class ProductPromotionViewHolder(private val binding: ItemCategoryPromotionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
            binding.executePendingBindings()
        }
    }
}

class ProductDiffCallBack : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}
