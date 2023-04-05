package com.teamx.wallpaper.data.models.addcards

import androidx.annotation.Keep



@Keep
data class AddCardData(
    val application: Any,
    val cancellation_reason: Any,
    val client_secret: String,
    val created: Int,
    val customer: String,
    val description: Any,
    val flow_directions: Any,
    val id: String,
    val last_setup_error: Any,
    val latest_attempt: String,
    val livemode: Boolean,
    val mandate: Any,
    val metadata: Metadata,
    val next_action: Any,
    val `object`: String,
    val on_behalf_of: Any,
    val payment_method: String,
    val payment_method_options: PaymentMethodOptions,
    val payment_method_types: List<String>,
    val single_use_mandate: Any,
    val status: String,
    val usage: String
)