package com.example.demo_mvp_zomatofood.data.source

import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.data.source.remote.OnFetchDataListener

interface FoodDataSource {

    interface Local
    interface Remote {
        fun getFood(listener: OnFetchDataListener<MutableList<Food>>)
    }
}
