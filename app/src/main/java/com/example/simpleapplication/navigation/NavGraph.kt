package com.example.simpleapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.simpleapplication.data.model.ApodItem
import com.example.simpleapplication.ui.ApodDetailScreen
import com.example.simpleapplication.ui.ApodListScreen
import com.google.gson.Gson
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import com.example.simpleapplication.viewmodel.ApodViewModel

sealed class Screen(val route: String) {
    object ListScreen : Screen("list_screen")
    object DetailScreen : Screen("detail_screen/{item}") {
        fun createRoute(item: ApodItem): String {
            val itemJson = Gson().toJson(item)
            val encodedJson = URLEncoder.encode(itemJson, StandardCharsets.UTF_8.toString())
            return "detail_screen/$encodedJson"
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController, viewModel: ApodViewModel) {
    NavHost(navController = navController, startDestination = Screen.ListScreen.route) {
        composable(Screen.ListScreen.route) {
            ApodListScreen(viewModel) { selectedItem ->
                navController.navigate(Screen.DetailScreen.createRoute(selectedItem))
            }
        }
        composable(Screen.DetailScreen.route) { backStackEntry ->
            val itemJson = backStackEntry.arguments?.getString("item")
            val decodedJson = URLDecoder.decode(itemJson, StandardCharsets.UTF_8.toString())
            val item = Gson().fromJson(decodedJson, ApodItem::class.java)
            ApodDetailScreen(item)
        }
    }
}