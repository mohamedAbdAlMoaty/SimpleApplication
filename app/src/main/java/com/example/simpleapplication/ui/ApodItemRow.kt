package com.example.simpleapplication.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
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
import com.example.simpleapplication.R
import com.example.simpleapplication.data.model.ApodItem

@Composable
fun ApodItemRow(item: ApodItem, onItemClick: (ApodItem) -> Unit) {
    val imageUrl = item.imageUrl.takeIf { !it.isNullOrEmpty() }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(item) },
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            if (imageUrl != null) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "APOD Image",
                    modifier = Modifier.size(64.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.default_image),
                    contentDescription = "Default APOD Image",
                    modifier = Modifier.size(64.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text( text = item.title,style = MaterialTheme.typography.h6.copy(fontSize = 15.sp))
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = item.date,style = MaterialTheme.typography.subtitle2.copy(color = Color.Gray))
            }
        }
    }
}

