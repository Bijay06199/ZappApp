package com.example.zappapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.zappapp.data.room.dao.SavedPhotoDao
import com.example.zappapp.ui.model.Photo

@Database(entities = [Photo::class],version = 1)
@TypeConverters(Converter::class)

abstract class ZappDatabase:RoomDatabase() {
    abstract fun savedPhotoDao():SavedPhotoDao
    companion object {
        private var INSTANCE: ZappDatabase? = null

        fun getDatabase(context: Context): ZappDatabase? {

            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder<ZappDatabase>(
                        context.applicationContext, ZappDatabase::class.java, "zapp_database"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE
        }
    }
}