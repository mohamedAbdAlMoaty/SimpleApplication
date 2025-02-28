package com.example.simpleapplication.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.simpleapplication.data.network.ApodApiService
import com.example.simpleapplication.data.repository.ApodRepository
import com.example.simpleapplication.viewmodel.ApodViewModel
import com.example.simpleapplication.navigation.NavGraph
import com.example.simpleapplication.utils.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiService = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApodApiService::class.java)
        val repository = ApodRepository(apiService)
         val viewModel = ApodViewModel(repository)

        setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController, viewModel = viewModel)
        }
    }
}