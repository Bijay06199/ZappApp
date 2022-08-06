package com.example.zappapp.ui

import com.example.zappapp.data.userDatabaseManager.UserDatabaseManager
import com.example.zappapp.ui.model.Photo

interface SavedPhotoRepository{
    suspend fun savePhoto(photo: Photo)
    suspend fun updatePhoto(photo: Photo)
    suspend fun deletePhoto(id:Int)
    suspend fun getPhoto():List<Photo>
}

class SavedPhotoRepositoryImp(
    private val userDatabaseManager: UserDatabaseManager
    ):SavedPhotoRepository {


    override suspend fun savePhoto(photo: Photo) {
        return userDatabaseManager.savePhoto(photo)
    }

    override suspend fun updatePhoto(photo: Photo) {
        return userDatabaseManager.updatePhoto(photo)
    }

    override suspend fun deletePhoto(id: Int) {
        return userDatabaseManager.deletePhoto(id)
    }

    override suspend fun getPhoto(): List<Photo> {
        return userDatabaseManager.getPhoto()
    }


}