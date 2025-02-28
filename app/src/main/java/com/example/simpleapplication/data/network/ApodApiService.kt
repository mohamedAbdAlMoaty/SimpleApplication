package com.example.simpleapplication.data.network


import com.example.simpleapplication.data.model.ApodItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApiService {
    @GET("planetary/apod")
    suspend fun getApod(
        @Query("api_key") apiKey: String,
        @Query("count") count: Int = 10
    ): List<ApodItem>
}