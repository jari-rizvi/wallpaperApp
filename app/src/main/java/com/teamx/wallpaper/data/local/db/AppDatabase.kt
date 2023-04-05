package com.teamx.wallpaper.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.teamx.wallpaper.constants.AppConstants
import com.teamx.wallpaper.data.local.TypeConverterMV
import com.teamx.wallpaper.data.local.dbModel.CartDao
import com.teamx.wallpaper.data.local.dbModel.CartTable
import com.teamx.wallpaper.data.models.MusicModel


@Database(
    entities = [MusicModel::class, CartTable::class],
    version = 13,
    exportSchema = false
)

@TypeConverters(TypeConverterMV::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao
    abstract fun cartDao(): CartDao


    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance
                ?: synchronized(this) {
                    instance
                        ?: buildDatabase(
                            context
                        )
                            .also { instance = it }
                }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(
                appContext,
                AppDatabase::class.java,
                AppConstants.DbConfiguration.DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }

}