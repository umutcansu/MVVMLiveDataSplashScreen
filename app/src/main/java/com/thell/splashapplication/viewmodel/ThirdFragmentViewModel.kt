package com.thell.splashapplication.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.thell.splashapplication.util.BaseViewModel
import com.thell.splashapplication.util.CustomSharedPreferences

class ThirdFragmentViewModel(application: Application) : BaseViewModel(application) {

    var fragmentIndex = MutableLiveData<Int>()
    var fragmentFinish = MutableLiveData<Boolean>()

    fun finishFragment()
    {
        CustomSharedPreferences(getApplication()).saveOnBoarding(true)
        fragmentFinish.value = true
    }

    fun prevFragment()
    {
        fragmentIndex.value = 1
    }

}