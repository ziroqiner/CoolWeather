package com.coolweather.Android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class CoolWeatherApplication:Application() {
    companion object{
        const val TOKEN = "lingpai"
        @SuppressLint("StaticFieldLeak")
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}