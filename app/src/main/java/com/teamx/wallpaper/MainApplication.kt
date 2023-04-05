package com.teamx.wallpaper

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.teamx.wallpaper.utils.localization.LocaleManager
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    companion object {
        var application: Application? = null
            private set
        val context: Context
            get() = application!!.applicationContext
        val PACKAGE_NAME: String
            get() = application!!.packageName

        var localeManager: LocaleManager? = null

    }

    override fun onCreate() {
        super.onCreate()

        application = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }


    }

}