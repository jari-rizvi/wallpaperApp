package com.teamx.wallpaper.dummyData

import androidx.annotation.Keep



@Keep
class Cart(
     val id: Int,
     val name: String,
     val modifier: String,
     val price: Double = 0.0,
     val imageUrl: String,
     var quantity: Int = 1,
     var variationId : String = ""

)


