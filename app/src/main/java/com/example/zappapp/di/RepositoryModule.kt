package com.example.zappapp.di

import com.example.zappapp.data.room.dao.SavedPhotoDao
import com.example.zappapp.data.userDatabaseManager.UserDatabaseManager
import com.example.zappapp.data.userDatabaseManager.UserDatabaseManagerImpl
import com.example.zappapp.ui.SavedPhotoRepository
import com.example.zappapp.ui.SavedPhotoRepositoryImp
import org.koin.dsl.module

val repositoryModule= module {
    single { provideUserDaoManager(get()) }
    single { providePhotoRepository(get()) }
}

fun  provideUserDaoManager(
    photoDao: SavedPhotoDao
):UserDatabaseManager{
    return UserDatabaseManagerImpl(
        photoDao
    )
}

fun providePhotoRepository(
    userDatabaseManager: UserDatabaseManager
):SavedPhotoRepository{
    return SavedPhotoRepositoryImp(userDatabaseManager)
}