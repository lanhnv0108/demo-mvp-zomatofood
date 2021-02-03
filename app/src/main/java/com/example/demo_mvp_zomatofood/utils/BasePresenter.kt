package com.example.demo_mvp_zomatofood.utils

interface BasePresenter<T> {

    fun onStart()
    fun onStop()
    fun setView(view: T?)
}
