package com.miracle.memorial.presentation.utils

import android.app.Application
import com.miracle.memorial.data.utils.PreferenceManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MemorialApp : Application() {

    // companion object 를 사용해
    // PreferenceManager 객체를 만든 적이 있으면 다시 만들지 않음
    companion object {
        lateinit var prefs: PreferenceManager
    }

    override fun onCreate() {
        prefs = PreferenceManager(applicationContext)
        super.onCreate()
    }
}