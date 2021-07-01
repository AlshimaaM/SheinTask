package com.example.sheintask.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sheintask.R

class ViewPagerAdapter(private val offerList: List<String>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.offer_item, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val title = offerList[position]
        holder.bind(title)
    }

    override fun getItemCount(): Int {
        return 3
    }



    class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val text1= itemView.findViewById<TextView>(R.id.offer_title)

        fun bind(title: String) {
            text1.text= title

        }
    }
}