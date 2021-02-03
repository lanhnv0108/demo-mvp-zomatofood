package com.example.demo_mvp_zomatofood.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_mvp_zomatofood.data.model.Food
import demo_mvp_zomatofood.R

class AdapterHomeFood(private var onItemClicked: (Food) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    private val foods = mutableListOf<Food>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(foods[position])
    }

    override fun getItemCount() = foods.size

    fun updateData(food: MutableList<Food>?) {
        food?.let {
            foods.clear()
            foods.addAll(it)
            notifyDataSetChanged()
        }
    }
}
