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

class ReviewsAdapter(var reviews: ArrayList<ReviewItem>) :
        RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder>() {


    fun updateReviews(newReviews: List<ReviewItem>) {
        reviews.clear()
        reviews.addAll(newReviews)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ReviewViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.review_item, parent, false)
    )
    override fun getItemCount() = reviews.size
    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(reviews[position])

    }
     class ReviewViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val comment = view.findViewById<TextView>(R.id.reviev_comment)

        fun bind(review: ReviewItem) {
            comment.text =review.comment


        }

    }

}