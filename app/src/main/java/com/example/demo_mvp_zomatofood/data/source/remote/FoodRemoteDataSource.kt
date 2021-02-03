package com.example.demo_mvp_zomatofood.data.source.remote

import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.data.model.FoodEntry
import com.example.demo_mvp_zomatofood.data.source.FoodDataSource
import com.example.demo_mvp_zomatofood.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.demo_mvp_zomatofood.utils.Constant

@Suppress("DEPRECATION")
class FoodRemoteDataSource : FoodDataSource.Remote {

    private val baseUrl = Constant.BASE_URL + Constant.BASE_CITY

    override fun getFood(listener: OnFetchDataListener<MutableList<Food>>) {
        GetJsonFromUrl(listener, FoodEntry.COLLECTIONS).execute(baseUrl)
    }

    private object Holder {
        val INSTANCE = FoodRemoteDataSource()
    }

    companion object {
        val instance: FoodRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
