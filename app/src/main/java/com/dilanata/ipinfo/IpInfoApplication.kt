package com.dilanata.ipinfo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class IpInfoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (true) {
            Timber.plant(Timber.DebugTree())
        }
    }
}