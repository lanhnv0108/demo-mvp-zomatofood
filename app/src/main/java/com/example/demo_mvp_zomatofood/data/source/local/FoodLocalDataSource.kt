package com.example.demo_mvp_zomatofood.data.source.local

import com.example.demo_mvp_zomatofood.data.source.FoodDataSource

class FoodLocalDataSource : FoodDataSource.Local {

    private object Holder {
        val INSTANCE = FoodLocalDataSource()
    }

    companion object {
        val instance: FoodLocalDataSource by lazy { Holder.INSTANCE }
    }
}
