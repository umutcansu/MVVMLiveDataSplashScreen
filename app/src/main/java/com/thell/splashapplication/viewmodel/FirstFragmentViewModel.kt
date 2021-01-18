package com.thell.splashapplication.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.thell.splashapplication.util.BaseViewModel

class FirstFragmentViewModel(application: Application) : BaseViewModel(application) {

    var fragmentIndex = MutableLiveData<Int>()

    fun nextFragment()
    {
        fragmentIndex.value = 1
    }

}