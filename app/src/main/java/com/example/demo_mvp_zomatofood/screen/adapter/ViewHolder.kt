package com.example.demo_mvp_zomatofood.screen.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo_mvp_zomatofood.data.model.Food
import kotlinx.android.synthetic.main.item_food.view.*

class ViewHolder(
    itemView: View,
    private var onItemClicked: (Food) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun binData(food: Food) {
        itemView.apply {
            textViewTitleFood.text = food.title.trim()
            textViewDescriptionFood.text = food.description.trim()
            setOnClickListener {
                onItemClicked(food)
            }
        }
        getImage(food)
    }

    private fun getImage(food: Food) {
        Glide.with(itemView.context)
            .load(food.imageUrl)
            .into(itemView.imageFood)
    }
}
