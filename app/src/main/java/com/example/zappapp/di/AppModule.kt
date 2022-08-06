package com.example.zappapp.di

import android.content.Context
import android.content.res.Resources
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.dsl.module

val appModule = module {

    single { provideResources(get()) }
    factory { CoroutineScope(Dispatchers.Main + Job()) }

    single { Gson() }
}




fun provideResources(context: Context): Resources = context.resources