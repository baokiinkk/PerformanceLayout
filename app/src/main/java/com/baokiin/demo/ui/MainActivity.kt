package com.baokiin.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.baokiin.demo.R
import com.baokiin.demo.ui.demo.DemoFragment
import com.baokiin.demo.ui.home.HomeConcatFragment
import com.baokiin.demo.ui.home.HomeMotionFragment
import com.baokiin.demo.ui.home.HomeFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val tabLayout by lazy { findViewById<TabLayout>(R.id.tablayout) }
    val viewPager by lazy { findViewById<ViewPager2>(R.id.viewpager) }
    val viewPagerAdapter by lazy {
        val demoLayoutFragment = DemoFragment()
        val homeFragment = HomeFragment()
        val homeConcatFragment = HomeConcatFragment()
        val homeMotionFragment = HomeMotionFragment()
        ViewPagerAdapter(
            list = mutableListOf(
                demoLayoutFragment,
                homeFragment,
                homeConcatFragment,
                homeMotionFragment
            ),
            fragmentManager = supportFragmentManager,
            lifeCycle = lifecycle
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }
}