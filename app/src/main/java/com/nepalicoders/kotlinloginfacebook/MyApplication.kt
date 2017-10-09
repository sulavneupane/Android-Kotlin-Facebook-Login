package com.nepalicoders.kotlinloginfacebook

import android.app.Application
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Sulav on 10/8/17.
 */

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)
    }
}