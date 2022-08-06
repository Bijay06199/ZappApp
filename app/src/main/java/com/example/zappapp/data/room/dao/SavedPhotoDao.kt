package com.example.zappapp.data.room.dao

import androidx.room.*
import com.example.zappapp.ui.model.Photo


@Dao
interface SavedPhotoDao {
    @Query("SELECT * FROM photo_table")
    fun getAll():List<Photo>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg photo: Photo)

    @Query("select * from photo_table where id Like :id")
    fun getPhotoById(id:Int):List<Photo>

    @Update
    fun update(vararg photoModel:Photo)

    @Query("delete from photo_table where id Like :id")
    fun deletePhotoById(id: Int)

}