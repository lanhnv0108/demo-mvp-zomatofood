package com.example.demo_mvp_zomatofood.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demo_mvp_zomatofood.data.model.Food
import com.example.demo_mvp_zomatofood.data.source.repository.FoodRepository
import com.example.demo_mvp_zomatofood.screen.adapter.AdapterHomeFood
import com.example.demo_mvp_zomatofood.utils.OnItemRecyclerViewClickListener
import demo_mvp_zomatofood.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeFood : AppCompatActivity(), ViewContractHomeFood.View,
    OnItemRecyclerViewClickListener<Food> {

    private val adapter by lazy { AdapterHomeFood() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    override fun onGetViewSuccess(foods: MutableList<Food>) {
        adapter.updateData(foods)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: Food?) {
        Toast.makeText(this, item?.title, Toast.LENGTH_LONG).show()
    }

    private fun initView() {
        recyclerViewFood.apply {
            setHasFixedSize(true)
            adapter = this@HomeFood.adapter
        }
        this@HomeFood.adapter.registerItemRecyclerViewClickListener(this)
    }

    private fun initData() {
        val presenter = HomeFoodPresenter(FoodRepository.getInstance())
        presenter.setView(this)
        presenter.onStart()
    }
}
