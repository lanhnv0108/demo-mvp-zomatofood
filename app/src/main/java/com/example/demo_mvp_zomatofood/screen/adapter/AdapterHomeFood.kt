package com.example.demo_mvp_zomatofood.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.utils.OnItemRecyclerViewClickListener
import demo_mvp_zomatofood.R

class AdapterHomeFood : RecyclerView.Adapter<ViewHolder>() {

    private val foods = mutableListOf<Food>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Food>? = null

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Food>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view, onItemClickListener, foods)
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
