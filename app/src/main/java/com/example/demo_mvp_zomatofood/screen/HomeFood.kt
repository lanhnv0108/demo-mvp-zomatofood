package com.example.demo_mvp_zomatofood.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.data.source.repository.FoodRepository
import com.example.demo_mvp_zomatofood.screen.adapter.AdapterHomeFood
import demo_mvp_zomatofood.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeFood : AppCompatActivity(), ViewContractHomeFood.View {

    private val adapter by lazy {
        AdapterHomeFood() {
            Toast.makeText(this, it.title, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reloadSwipe()
        initView()
        initData()
    }

    override fun onGetViewSuccess(foods: MutableList<Food>) {
        adapter.updateData(foods)
    }

    override fun onError(exception: Exception?) {}

    private fun initView() {
        recyclerViewFood.apply {
            setHasFixedSize(true)
            adapter = this@HomeFood.adapter
        }
    }
    private fun reloadSwipe(){

    }

    private fun initData() {
        val presenter = HomeFoodPresenter(FoodRepository.getInstance())
        presenter.apply {
            setView(this@HomeFood)
            onStart()
        }
    }
}
