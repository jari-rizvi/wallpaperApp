package com.teamx.wallpaper.dummyData
import androidx.annotation.Keep

@Keep
data class Response(
    val create_time: String,
    val id: String,
    val intent: String,
    val state: String
)