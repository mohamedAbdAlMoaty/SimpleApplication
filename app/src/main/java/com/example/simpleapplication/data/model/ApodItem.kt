package com.example.simpleapplication.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApodItem(
    val date: String,
    val title: String,
    val imageUrl: String,
    val explanation: String
) : Parcelable