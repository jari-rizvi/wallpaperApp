package com.teamx.wallpaper.data.models

import androidx.room.Entity

@Entity
class IntroModel(
    val title: String,
    val description: String,
    val image: Int,
)