package com.example.demo_mvp_zomatofood.data.source.repository

import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.data.source.FoodDataSource
import com.example.demo_mvp_zomatofood.data.source.local.FoodLocalDataSource
import com.example.demo_mvp_zomatofood.data.source.remote.FoodRemoteDataSource
import com.example.demo_mvp_zomatofood.data.source.remote.OnFetchDataListener

class FoodRepository private constructor(
    private val remote: FoodDataSource.Remote,
    private val local: FoodDataSource.Local
) {

    fun getFood(listener: OnFetchDataListener<MutableList<Food>>) {
        remote.getFood(listener)
    }

    companion object {
        private var INSTANCE: FoodRepository? = null
        fun getInstance(): FoodRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: FoodRepository(
                    remote = FoodRemoteDataSource.instance,
                    local = FoodLocalDataSource.instance
                ).also { INSTANCE = it }
            }
        }
    }
}
