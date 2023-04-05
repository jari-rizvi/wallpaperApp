package com.teamx.wallpaper.dummyData
import androidx.annotation.Keep

@Keep
data class Client(
    val environment: String,
    val paypal_sdk_version: String,
    val platform: String,
    val product_name: String
)