package com.example.zappapp.data.room

import androidx.room.TypeConverter
import com.example.zappapp.ui.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun StringToPhoto(dataString: String?): Photo? {
        return Gson().fromJson<Photo>(dataString, object : TypeToken<Photo>() {}.type)
    }

    @TypeConverter
    fun PhotoToString(photo: Photo?): String? {
        return Gson().toJson(photo)
    }

    @TypeConverter
    fun StringToAlbum(dataString: String?): Album? {
        return Gson().fromJson<Album>(dataString, object : TypeToken<Album>() {}.type)
    }

    @TypeConverter
    fun AlbumToString(album: Album?): String? {
        return Gson().toJson(album)
    }

    @TypeConverter
    fun StringToPost(dataString: String?): Post? {
        return Gson().fromJson<Post>(dataString, object : TypeToken<Post>() {}.type)
    }

    @TypeConverter
    fun PostToString(post: Post?): String? {
        return Gson().toJson(post)
    }

    @TypeConverter
    fun StringToTodo(dataString: String?): Todo? {
        return Gson().fromJson<Todo>(dataString, object : TypeToken<Todo>() {}.type)
    }

    @TypeConverter
    fun TodoToString(todo: Todo): String? {
        return Gson().toJson(todo)
    }

    @TypeConverter
    fun StringToComment(dataString: String?): Comment? {
        return Gson().fromJson<Comment>(dataString, object : TypeToken<Comment>() {}.type)
    }

    @TypeConverter
    fun CommentToString(comment: Comment?): String? {
        return Gson().toJson(comment)
    }
}