package com.teamx.wallpaper.data.models.addcards

import androidx.annotation.Keep



@Keep
data class Card(
    val mandate_options: Any,
    val network: Any,
    val request_three_d_secure: String
)