package com.thell.splashapplication.viewmodel

import android.app.Application
import androidx.fragment.app.Fragment
import com.thell.splashapplication.ui.onboarding.screens.FirstFragment
import com.thell.splashapplication.ui.onboarding.screens.SecondFragment
import com.thell.splashapplication.ui.onboarding.screens.ThirdFragment
import com.thell.splashapplication.util.BaseViewModel

class ViewPagerFragmentViewModel(application: Application):BaseViewModel(application) {

    val fragmentList = arrayListOf<Fragment>(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment(),
    )
}