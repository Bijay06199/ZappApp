package com.example.zappapp.di

import android.app.Application
import androidx.room.Room
import com.example.zappapp.data.room.ZappDatabase
import com.example.zappapp.data.room.dao.SavedPhotoDao
import com.example.zappapp.utils.constants.AppContracts
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule= module {
    single { provideDatabase(androidApplication()) }
    single { provideSavePhoto(get()) }
}

fun provideDatabase(
    context: Application
): ZappDatabase {
    return Room.databaseBuilder(
        context,
        ZappDatabase::class.java,
        AppContracts.Strings.DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
}

fun provideSavePhoto(zappDatabase: ZappDatabase):SavedPhotoDao = zappDatabase.savedPhotoDao()