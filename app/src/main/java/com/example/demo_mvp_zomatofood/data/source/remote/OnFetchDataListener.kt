package com.example.demo_mvp_zomatofood.data.source.remote

import java.lang.Exception

interface OnFetchDataListener<T> {

    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}
