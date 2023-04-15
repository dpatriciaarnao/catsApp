package com.example.catsapp

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CatsApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
    }
}
