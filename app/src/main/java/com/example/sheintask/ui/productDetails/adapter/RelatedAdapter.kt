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

class RelatedAdapter(var relateds: ArrayList<DataProduct>) :
        RecyclerView.Adapter<RelatedAdapter.ReviewViewHolder>() {


    fun updateRelateds(newRelateds: List<DataProduct>) {
        relateds.clear()
        relateds.addAll(newRelateds)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ReviewViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.related_item, parent, false)
    )
    override fun getItemCount() = relateds.size
    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(relateds[position])

    }
     class ReviewViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

         private val relatedImg = view.findViewById<ImageView>(R.id.related_img)
         private val name = view.findViewById<TextView>(R.id.product_name)
         private val oldPrice = view.findViewById<TextView>(R.id.old_price)
         private val newPrice = view.findViewById<TextView>(R.id.new_price)

        fun bind(related: DataProduct) {
            Glide.with(relatedImg.context).load(related.products.image).placeholder(R.drawable.ic_search).into(relatedImg)
            name.text =related.products.name
            oldPrice.text =related.products.oldPrice.toString()+" EGP"
            newPrice.text = related.products.newPrice.toString()+" EGP"
            oldPrice.paintFlags = oldPrice.paintFlags or  Paint.STRIKE_THRU_TEXT_FLAG

        }

    }

}