package com.nightowl094.retrofitunittestwithcoroutine.data


import com.google.gson.annotations.SerializedName

data class CommentDTOItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("postId")
    val postId: Int
)