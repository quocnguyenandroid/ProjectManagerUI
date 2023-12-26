package com.qndev.projectmanagerui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.qndev.projectmanagerui.adapter.OngoingAdapter
import com.qndev.projectmanagerui.databinding.ActivityMainBinding
import com.qndev.projectmanagerui.domain.OngoingDomain

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycleView()
    }

    private fun initRecycleView() {
        val items = mutableListOf<OngoingDomain>()
        items.add(OngoingDomain("Food App", "Dec 26, 2023", 50, "ongoing1"))
        items.add(OngoingDomain("AI Recording", "Nov 16, 2023", 60, "ongoing2"))
        items.add(OngoingDomain("Weather App", "Aug 23, 2023", 40, "ongoing3"))
        items.add(OngoingDomain("E-Book App", "Sep 06, 2023", 80, "ongoing4"))
        binding.onGoingView.layoutManager = GridLayoutManager(this, 2)
        binding.onGoingView.adapter = OngoingAdapter(items)
    }
}