package com.example.shoppingapp.ui.categorydetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.example.shoppingapp.common.KEY_CATEGORY_LABEL
import com.example.shoppingapp.databinding.FragmentCategoryDetailBinding
import com.example.shoppingapp.ui.common.ProductClickListener
import com.example.shoppingapp.ui.common.ProductPromotionAdapter
import com.example.shoppingapp.ui.common.SectionTitleAdapter
import com.example.shoppingapp.ui.common.ViewModelFactory

class CategoryDetailFragment : Fragment(), ProductClickListener {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel: CategoryDetailViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,

        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setListAdapter()
    }

    override fun onProductClick(productId: String) {
        // TODO ProductDetailFragment 이동 구현
    }

    private fun setToolbar() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
    }

    private fun setListAdapter() {
        val topSellingSectionAdapter = CategoryTopSellingSectionAdapter()
        val titleAdapter = SectionTitleAdapter()
        /* ProductClickListener를 상속받은 CategoryDetailFragment도
        이 인터페이스의 기능을 확장한 것이기 때문에 this 참조로 전달 가능*/
        val promotionAdapter = ProductPromotionAdapter(this)
        binding.rvCategoryDetail.adapter =
            ConcatAdapter(topSellingSectionAdapter, titleAdapter, promotionAdapter)
        viewModel.topSelling.observe(viewLifecycleOwner) { topSelling ->
            topSellingSectionAdapter.submitList(listOf(topSelling))
        }

        viewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
            Log.d("프로모션", "${promotions.title}")
            Log.d("프로모션", "${promotions.items}")
        }
    }
}
