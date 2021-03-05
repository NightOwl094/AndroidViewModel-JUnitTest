package com.nightowl094.retrofitunittestwithcoroutine.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JSONPlaceholderRemoteSource {

    val jsonPlaceholderRemoteSource: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}