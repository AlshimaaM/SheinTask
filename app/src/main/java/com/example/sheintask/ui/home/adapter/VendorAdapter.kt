package com.example.sheintask.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sheintask.R
import com.example.sheintask.data.SponsorsItem
import com.example.sheintask.data.VendorItem

class VendorAdapter(var vendors: ArrayList<VendorItem>) :
        RecyclerView.Adapter<VendorAdapter.VendorViewHolder>() {


    fun updateVendor(newVendor: List<VendorItem>) {
        vendors.clear()
        vendors.addAll(newVendor)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = VendorViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vendors_item, parent, false)
    )
    override fun getItemCount() = vendors.size
    override fun onBindViewHolder(holder: VendorViewHolder, position: Int) {
        holder.bind(vendors[position])

    }
    class VendorViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val vendorImg = view.findViewById<ImageView>(R.id.vendor_img)
        private val vendorName = view.findViewById<TextView>(R.id.vendor_name)
        fun bind(vendor: VendorItem) {
            Glide.with(vendorImg.context).load(vendor.image).placeholder(R.drawable.ic_search).into(vendorImg)
            vendorName.text =vendor.name
        }
    }
}