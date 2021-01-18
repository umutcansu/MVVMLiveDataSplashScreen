package com.thell.splashapplication.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class CustomSharedPreferences {

    companion object
    {
        private const val FINISH_ON_BOARDING = "FINISH_ON_BOARDING"

        var sharedPreferences : SharedPreferences? = null

        @Volatile private var instance : CustomSharedPreferences? = null

        private val lockObject  = Any()

        operator  fun invoke(context: Context) : CustomSharedPreferences
        {
            return instance ?: synchronized(lockObject) {
                instance ?: createCustomSharedPreferences(context).also {
                    instance = it
                }
            }
        }


        private  fun createCustomSharedPreferences(context: Context):CustomSharedPreferences
        {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }


    }

    fun saveOnBoarding(state:Boolean)
    {
        sharedPreferences?.apply {
            edit(commit = true){
                putBoolean(FINISH_ON_BOARDING,state)
            }
        }
    }

    fun getOnBoarding():Boolean
    {
        var result = false
        sharedPreferences?.apply {
            result =  getBoolean(FINISH_ON_BOARDING,false)
        }
        return result
    }
}