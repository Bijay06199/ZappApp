package com.example.zappapp.data.userDatabaseManager

import com.example.zappapp.data.room.dao.SavedPhotoDao
import com.example.zappapp.ui.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UserDatabaseManager {

    suspend fun savePhoto(photo: Photo)
    suspend fun updatePhoto(photo: Photo)
    suspend fun deletePhoto(id:Int)
    suspend fun getPhoto():List<Photo>
}

class  UserDatabaseManagerImpl(
    private val photoDao: SavedPhotoDao
):UserDatabaseManager{
    override suspend fun savePhoto(photo: Photo) {
        withContext(Dispatchers.IO){
            photoDao.insert(photo)
        }
    }

    override suspend fun updatePhoto(photo: Photo) {
        withContext(Dispatchers.IO){
            photoDao.update(photo)
        }
    }

    override suspend fun deletePhoto(id: Int) {
       withContext(Dispatchers.IO){
           photoDao.deletePhotoById(id)
       }
    }

    override suspend fun getPhoto(): List<Photo> {
      return withContext(Dispatchers.IO){
           photoDao.getAll()
       }
    }


}