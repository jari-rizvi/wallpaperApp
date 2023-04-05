package com.teamx.wallpaper.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class PrefHelper private constructor() {

    companion object {
        private val sharePref = PrefHelper()
        private lateinit var sharedPreferences: SharedPreferences

        private val PLACE_OBJ = "place_obj"
        private val PAYTYPE = "pay_type"
        private val SPECIAL_INSTRUCATIONS = "special_instructions"
        private val USER_ID = "user_id"
        private val MERCHANT_ID = "merchant_id"
        private val ORDER_ID = "order_id"
        private const val dbCardP = "dbCardP"
        private val LANGTYPE = "lang_type"
        private val CARPLATE = "car_plate"
        private const val shippingConst = "_shippingAddress"
        private const val favouriteShop = "_favouriteShop"
        private const val favouriteProduct = "_favouriteProduct"
        private const val shippingConst2 = "_shippingAddress2"
        private const val carConst = "_carConstant"
        private const val STRIPE_ID = "stripe"
        private const val STRIPE_Name = "stripe_name"
        private const val NOTIFICATION_ENABLE = "notificationEnable"


        fun getInstance(context: Context): PrefHelper {
            if (!::sharedPreferences.isInitialized) {
                synchronized(PrefHelper::class.java) {
                    if (!::sharedPreferences.isInitialized) {
                        sharedPreferences =
                            context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
                    }
                }
            }
            return sharePref
        }
    }


}