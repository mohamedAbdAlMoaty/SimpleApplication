package com.example.simpleapplication.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.simpleapplication.data.model.ApodItem
import com.example.simpleapplication.viewmodel.ApodViewModel

@Composable
fun ApodListScreen(viewModel: ApodViewModel, onItemClick: (ApodItem) -> Unit) {
    val items by viewModel.items.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        if (items.isEmpty()) {  // Prevent re-fetching on return
            viewModel.fetchApodItems("AyzCwYI6YTqdi4zgSlIT5rwHucGUqh73MICRnEQx")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()  // Ensures full usage of screen space
    ) {
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()
        ) {
            items(items, key = { it.date }) { item ->
                ApodItemRow(item = item, onItemClick = onItemClick)
            }
        }
    }
}
