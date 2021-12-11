package com.example.pizzaorderapp_20211211

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizzaorderapp_20211211.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mvpa : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    private fun setupEvents() {

    }

    private fun setValues() {
        mvpa = MainViewPagerAdapter( supportFragmentManager )
        mainViewPager.adapter = mvpa
    }
}