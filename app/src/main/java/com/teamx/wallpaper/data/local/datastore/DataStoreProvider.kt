package com.teamx.wallpaper.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.teamx.wallpaper.MainApplication.Companion.context
import com.teamx.wallpaper.constants.AppConstants

class DataStoreProvider(context: Context) {

    //Create the dataStore
//    private val dataStore : DataStore<Preferences> = context.createDataStore(name = AppConstants.DataStore.DATA_STORE_NAME)

    //Create some keys
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = AppConstants.DataStore.DATA_STORE_NAME)
        val IS_LOCALIZATION_KEY = booleanPreferencesKey(AppConstants.DataStore.LOCALIZATION_KEY_NAME)
        val USER_NAME_KEY = stringPreferencesKey(AppConstants.DataStore.USER_NAME_KEY)
        val TOKEN = stringPreferencesKey(AppConstants.DataStore.TOKEN)
        val USER_ID = stringPreferencesKey(AppConstants.DataStore.USER_ID)
        val DETAILS = stringPreferencesKey(AppConstants.DataStore.DETAILS)
        val SAVE_ID = stringPreferencesKey(AppConstants.DataStore.SAVE_ID)
        val AVATAR = stringPreferencesKey(AppConstants.DataStore.AVATAR)
        val NAME = stringPreferencesKey(AppConstants.DataStore.NAME)
        val PAYTYPE = stringPreferencesKey(AppConstants.DataStore.PAYTYPE)
        val NUMBER = stringPreferencesKey(AppConstants.DataStore.NUMBER)

    }

    //Store data
    suspend fun storeData(isLocalizationKey: Boolean, name: String,token: String, details:String) {
        context.dataStore.edit {
            it[IS_LOCALIZATION_KEY] = isLocalizationKey
            it[USER_NAME_KEY] = name
            it[TOKEN] = token
            it[DETAILS] = details
        }

    }



}