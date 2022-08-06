package com.example.zappapp.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.example.zappapp.di.*
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ZappApp : Application() {

    companion object {
        lateinit var instance: ZappApp
    }

    override fun attachBaseContext(base: Context?) {
        MultiDex.install(this)
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        instance = this

        startKoin {
            androidContext(this@ZappApp)
            modules(
                listOf(
                    viewModelModule,
                    appModule,
                    databaseModule,
                    repositoryModule
                )
            )
        }
    }

}