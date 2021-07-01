package com.example.sheintask.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sheintask.R
import com.example.sheintask.data.SponsorsItem

class SponserAdapter(var sponsers: ArrayList<SponsorsItem>) :
        RecyclerView.Adapter<SponserAdapter.SponserViewHolder>() {


    fun updateSponser(newSponser: List<SponsorsItem>) {
        sponsers.clear()
        sponsers.addAll(newSponser)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = SponserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sponsers_item, parent, false)
    )
    override fun getItemCount() = sponsers.size
    override fun onBindViewHolder(holder: SponserViewHolder, position: Int) {
        holder.bind(sponsers[position])
    }


    class SponserViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.findViewById<ImageView>(R.id.sponser_image)
        fun bind(sponser: SponsorsItem) {
            Glide.with(imageView.context).load(sponser.image).placeholder(R.drawable.ic_search).into(imageView)

        }
    }
}