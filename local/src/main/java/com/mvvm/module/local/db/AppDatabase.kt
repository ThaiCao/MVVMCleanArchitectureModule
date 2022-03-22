package com.mvvm.module.local.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mvvm.module.local.dao.MovieCacheDao
import com.mvvm.module.local.utils.CacheConstants

abstract class AppDatabase  : RoomDatabase(){

    abstract fun movieCacheDao(): MovieCacheDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, AppDatabase::class.java, CacheConstants.DB_NAME
        ).build()
    }
}