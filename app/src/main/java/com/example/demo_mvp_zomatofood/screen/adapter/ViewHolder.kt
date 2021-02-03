package com.example.demo_mvp_zomatofood.screen.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_food.view.*

class ViewHolder(
    itemView: View,
    private val itemListener: OnItemRecyclerViewClickListener<Food>?,
    private val foods: MutableList<Food>
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var listener: OnItemRecyclerViewClickListener<Food>? = null

    fun binData(food: Food) {
        itemView.titleFood.text = food.title.trim()
        itemView.descriptionFood.text = food.description.trim()
        itemView.setOnClickListener(this)
        listener = itemListener
        getImage(food)
    }

    private fun getImage(food: Food) {
        Glide.with(itemView.context)
            .load(food.imageUrl)
            .into(itemView.imageFood)
    }

    override fun onClick(v: View?) {
        listener?.onItemClickListener(foods[adapterPosition])
    }
}
