package com.example.zappapp.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "photo_table")
data class Photo(



    var title: String?,
    var url: String?,
    var thumbnail: String?,
    var album: Album?,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
)


data class Album(
    @PrimaryKey
    var id: Int?,
    var title: String?,
    var user: User?,
    var photos: PhotosPage
)

data class User(
    @PrimaryKey
    var id: Int?,
    var name: String?,
    var userName: String?,
    var email: String?,
    var address: Address?,
    var phone: String?,
    var website: String?,
    var company: Company?,
    var posts: PostsPage?,
    var albums: AlbumsPage?,
    var todos: TodosPage
)

data class PhotosPage(
    var data: List<Photo>?,
    var links: PaginationLinks?,
    var meta: PageMetadata?,
)

data class Address(
    var street:String?,
    var suite:String?,
    var city:String?,
    var zipcode:String?,
    var geo:Geo
)


data class Company(
    var name:String?,
    var catchPhrase:String?,
    var bs:String
)

data class PostsPage(

    var data:List<Post>?,
    var links:PaginationLinks?,
    var meta:PageMetadata
)

data class AlbumsPage(
    var data:List<Album>?,
    var links:PaginationLinks?,
    var meta:PageMetadata
)

data class TodosPage(
    var data:List<Todo>?,
    var links:PaginationLinks?,
    var meta:PageMetadata
)

data class PaginationLinks(
    var first:PageLimitPair?,

)

data class PageLimitPair(
    var page:Int?,
    var limit:Int
)

data class PageMetadata(

    var totalCount:Int
)

data class Geo(
    var lat:Float?,
    var lng:Float
)

data class Post(

    @PrimaryKey
    var id:Int?,
    var title: String?,
    var body:String?,
    var user:User?,
    var comments:CommentsPage
)

data class CommentsPage(
    var data:List<Comment>?,
    var links:PaginationLinks?,
    var meta:PageMetadata
)

data class Comment(
    @PrimaryKey
    var id: Int?,
    var name: String?,
    var email: String?,
    var body: String?,
    var post:Post
)

data class Todo(
    @PrimaryKey
    var id: Int?,
    var title: String?,
    var completed:Boolean?,
    var user: User
)








