package com.teamx.wallpaper.data.remote.reporitory


import com.teamx.wallpaper.data.local.db.AppDao
import com.teamx.wallpaper.data.local.dbModel.CartDao
import com.teamx.wallpaper.data.remote.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService, var localDataSource: AppDao, var localDataSource2: CartDao
) {
//    suspend fun login(@Body param: JsonObject) = apiService.login(param)



}