package com.example.simpleapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import com.example.simpleapplication.R
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.simpleapplication.data.model.ApodItem

@Composable
fun ApodDetailScreen(item: ApodItem) {
    val imageUrl = item.imageUrl.takeIf { !it.isNullOrEmpty() }

    LazyColumn( modifier = Modifier.padding(16.dp)) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            if (imageUrl != null) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "APOD Image",
                    modifier = Modifier.fillMaxWidth().height(250.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.default_image),
                    contentDescription = "Default APOD Image",
                    modifier = Modifier.fillMaxWidth().height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.title, style = androidx.compose.material.MaterialTheme.typography.h4.copy(fontSize = 27.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.date, style = androidx.compose.material.MaterialTheme.typography.subtitle1.copy(color = Color.Gray))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.explanation, style = androidx.compose.material.MaterialTheme.typography.body1
                ,modifier = Modifier.fillMaxWidth())
        }
    }
}





