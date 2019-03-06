package com.example.kevic.demokoin

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppModule.inject()
    }

}