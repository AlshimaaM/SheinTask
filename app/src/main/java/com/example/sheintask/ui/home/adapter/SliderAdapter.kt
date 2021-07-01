package com.example.sheintask.ui.home.adapter

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

class SliderAdapter(var sliders: ArrayList<HotProductPaidStatusItem>,
                    private var listener : OnProductListener
) :
        RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {


    fun updateSlider(newSlider: List<HotProductPaidStatusItem>) {
        sliders.clear()
        sliders.addAll(newSlider)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slider_item, parent, false)
    )
    override fun getItemCount() = sliders.size
    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(sliders[position])

    }
    inner class SliderViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private val sliderImg = view.findViewById<ImageView>(R.id.slider_img)
        private val name = view.findViewById<TextView>(R.id.product_name)
        private val oldPrice = view.findViewById<TextView>(R.id.old_price)
        private val newPrice = view.findViewById<TextView>(R.id.new_price)
        private val date = view.findViewById<TextView>(R.id.date)
        private val rate = view.findViewById<TextView>(R.id.rate)

        fun bind(slider: HotProductPaidStatusItem) {
            Glide.with(sliderImg.context).load(slider.image).placeholder(R.drawable.ic_search).into(sliderImg)
            name.text =slider.name
            oldPrice.text = " $ "+slider.oldPrice.toString()
            newPrice.text = " $ "+slider.newPrice.toString()
            oldPrice.paintFlags = oldPrice.paintFlags or  Paint.STRIKE_THRU_TEXT_FLAG
            date.text = " End in "+slider.expDate
            rate.text =slider.rate.toString() +" Ratings"
        }
        init {
            view.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
                    listener.onProductDetailsClick(sliders[adapterPosition])
            }
    }
    interface OnProductListener
    {
        fun onProductDetailsClick(item: HotProductPaidStatusItem)
    }
}