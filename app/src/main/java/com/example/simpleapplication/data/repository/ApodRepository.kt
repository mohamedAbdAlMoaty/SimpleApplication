package com.example.simpleapplication.data.repository


import com.example.simpleapplication.data.model.ApodItem
import com.example.simpleapplication.data.network.ApodApiService

class ApodRepository(private val apiService: ApodApiService) {
    suspend fun fetchApodItems(apiKey: String, count: Int = 10): List<ApodItem> {
        return apiService.getApod(apiKey, count).sortedByDescending { it.date }
    }
}