package com.thell.splashapplication.util

import android.app.Activity
import androidx.viewpager2.widget.ViewPager2
import com.thell.splashapplication.R

class ActivityUtil
{
    companion object
    {

        const val SPLASH_TICK = 3000L

        fun changeSplashViewPagerFragment(activity : Activity?,index : Int)
        {
            activity?.apply {
                val  viewPager = findViewById<ViewPager2>(R.id.viewPager)
                viewPager.currentItem = index
            }
        }


    }
}