package com.example.zappapp.base

import com.google.gson.annotations.SerializedName

class BaseResponse<T> {
    @SerializedName("success")
    var success: String ? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("message")
    var responseMessage: String? = null

    @SerializedName("error")
    var error: Boolean? = null

    @SerializedName("data")
    var data: T? = null
}