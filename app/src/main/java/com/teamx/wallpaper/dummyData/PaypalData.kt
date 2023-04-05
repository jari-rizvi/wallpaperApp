package com.teamx.wallpaper.dummyData
import androidx.annotation.Keep

@Keep
data class PaypalData(
    val client: Client,
    val response: Response,
    val response_type: String
)