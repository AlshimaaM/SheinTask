package com.example.sheintask.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.sheintask.ProductDetailsActivity
import com.example.sheintask.R
import com.example.sheintask.data.*
import com.example.sheintask.databinding.FragmentHomeBinding
import com.example.sheintask.ui.home.adapter.SliderAdapter
import com.example.sheintask.ui.home.adapter.SponserAdapter
import com.example.sheintask.ui.home.adapter.VendorAdapter
import com.example.sheintask.ui.home.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment(), SliderAdapter.OnProductListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    var  sponserAdapter = SponserAdapter(arrayListOf())
    var  vendorAdapter = VendorAdapter(arrayListOf())
    var  sliderAdapter = SliderAdapter(arrayListOf(), this)
    private lateinit var sponserList:ArrayList<SponsorsItem>
    private lateinit var vendorList:ArrayList<VendorItem>
    private lateinit var sliderList:ArrayList<HotProductPaidStatusItem>
    private lateinit var viewPager2: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        initUI()
        loadProducts()

        return binding.root
    }

    private fun loadProducts() {
        homeViewModel.loadData().observe(requireActivity()) {
            it?.let {
                sponserList= it.data!!.sponsors as ArrayList<SponsorsItem>
                sponserAdapter.updateSponser(sponserList)
                vendorList= it.data!!.vendor as ArrayList<VendorItem>
                vendorAdapter.updateVendor(vendorList)
                sliderList= it.data.hotProductPaidStatus as ArrayList<HotProductPaidStatusItem>
                sliderAdapter.updateSlider(sliderList)

            }
        }
    }

    private fun initUI() {
        binding.recyclerSponser.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = sponserAdapter
        }
        binding.recyclerVendor.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = vendorAdapter
        }
        binding.recyclerSliders.apply {
            layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            adapter = sliderAdapter
        }
        var offers = mutableListOf<String>("Halloween1", "Halloween2", "Halloween3")
        val adapter = ViewPagerAdapter(offers)
       viewPager2 = binding.viewPager
        viewPager2.adapter = adapter
          binding.dotsIndicator.setViewPager2(viewPager2)


    }

    override fun onProductDetailsClick(item: HotProductPaidStatusItem) {
        val intent = Intent(requireContext(), ProductDetailsActivity::class.java)
        intent.putExtra("id",item.id)
        startActivity(intent)
    }
}