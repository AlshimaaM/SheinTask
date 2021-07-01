package com.example.sheintask.ui.productDetails.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sheintask.R
import com.example.sheintask.data.*
import com.example.sheintask.ui.home.adapter.SliderAdapter

class GallaryAdapter(var gallarys: ArrayList<GallaryItem>,private var listener :OnGallaryListener) :
        RecyclerView.Adapter<GallaryAdapter.ReviewViewHolder>() {


    fun updateGallary(newGallary: List<GallaryItem>) {
        gallarys.clear()
        gallarys.addAll(newGallary)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ReviewViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dress_item, parent, false)
    )
    override fun getItemCount() = gallarys.size
    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(gallarys[position])

    }
   inner  class ReviewViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener  {

        private val dressImg = view.findViewById<ImageView>(R.id.dress_img)

        fun bind(gallary: GallaryItem) {
            Glide.with(dressImg.context).load(gallary.images).placeholder(R.drawable.ic_search).into(dressImg)

        }
       init {
           dressImg.setOnClickListener(this)
       }
       override fun onClick(p0: View?) {
           listener.onGallarysClick(gallarys[adapterPosition])
       }
   }
    interface OnGallaryListener
    {
        fun onGallarysClick(item: GallaryItem)
    }

}