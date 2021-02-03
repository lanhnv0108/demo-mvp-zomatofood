package com.example.demo_mvp_zomatofood.screen

import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.utils.BasePresenter
import java.lang.Exception

interface ViewContractHomeFood {

    interface View {
        fun onGetViewSuccess(foods: MutableList<Food>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getMovie()
    }
}
