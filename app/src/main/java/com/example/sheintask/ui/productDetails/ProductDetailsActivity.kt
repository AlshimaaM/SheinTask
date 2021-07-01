package com.example.sheintask

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sheintask.data.DataProduct
import com.example.sheintask.data.GallaryItem
import com.example.sheintask.data.HotProductPaidStatusItem
import com.example.sheintask.data.ReviewItem
import com.example.sheintask.databinding.ActivityProductDetailsBinding
import com.example.sheintask.ui.home.HomeViewModel
import com.example.sheintask.ui.home.adapter.SliderAdapter
import com.example.sheintask.ui.home.adapter.SponserAdapter
import com.example.sheintask.ui.productDetails.ProductDetailsViewModel
import com.example.sheintask.ui.productDetails.adapter.GallaryAdapter
import com.example.sheintask.ui.productDetails.adapter.RelatedAdapter
import com.example.sheintask.ui.productDetails.adapter.ReviewsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ProductDetailsActivity : AppCompatActivity() , GallaryAdapter.OnGallaryListener{
    lateinit var binding:ActivityProductDetailsBinding
    private lateinit var viewModel: ProductDetailsViewModel
    var  reviewAdapter = ReviewsAdapter(arrayListOf())
    private lateinit var reviewList:ArrayList<ReviewItem>
    var  gallaryAdapter = GallaryAdapter(arrayListOf(),this)
    private lateinit var gallryList:ArrayList<GallaryItem>
    var  relatedAdapter = RelatedAdapter(arrayListOf())
    private lateinit var relatedList:ArrayList<DataProduct>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ProductDetailsViewModel::class.java)
        initUI()
        val id = intent.getIntExtra("id",0)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            finish()
        }
        if (id!=0){
            viewModel.getProductById(id)
        }

        viewModel.product?.observe(this, Observer {
            it?.let {
                binding.place.text=it.products.address
                binding.call.text=it.products.mobile
                binding.message.text=it.products.email
                binding.newPrice.text=it.products.newPrice.toString() +" EGP"
                binding.oldPrice.text=it.products.newPrice.toString() +" EGP"
                binding.oldPrice.paintFlags = binding.oldPrice.paintFlags or  Paint.STRIKE_THRU_TEXT_FLAG
                binding.date.text=it.products.expDate
                binding.descriptionTv.text=it.products.description
                reviewList= it.products.review as  ArrayList<ReviewItem>
                reviewAdapter.updateReviews(reviewList)
                gallryList= it.products.gallary as  ArrayList<GallaryItem>
                gallaryAdapter.updateGallary(gallryList)
                relatedList= arrayListOf(it)
                relatedAdapter.updateRelateds(relatedList)

            }
        })

    }
    private fun initUI() {
        binding.reviewsRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = reviewAdapter
        }
        binding.dressRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = gallaryAdapter
        }
        binding.relatedRecycler.apply {
            layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            adapter = relatedAdapter
        }
    }

    override fun onGallarysClick(item: GallaryItem) {
        CoroutineScope(Dispatchers.Main).launch {
            Glide.with(binding.dress).load(item.images).placeholder(R.drawable.ic_search).into(binding.dress)
        }
    }

}