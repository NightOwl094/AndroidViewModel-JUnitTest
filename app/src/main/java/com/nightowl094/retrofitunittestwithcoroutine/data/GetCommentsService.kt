package com.nightowl094.retrofitunittestwithcoroutine.data

import retrofit2.http.GET

interface GetCommentsService {
    @GET("comments")
    suspend fun fetchDummyCommentData(): List<CommentDTOItem>?
}