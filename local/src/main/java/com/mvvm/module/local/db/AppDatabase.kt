package com.mvvm.module.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvvm.module.local.converters.Converters
import com.mvvm.module.local.dao.MovieCacheDao
import com.mvvm.module.local.migration.Migrations
import com.mvvm.module.local.models.movies.MovieCache
import com.mvvm.module.local.utils.CacheConstants
@Database(
    entities = [
        MovieCache::class,

    ],
    version = Migrations.DB_VERSION,
    exportSchema = false
)
@TypeConverters(
    Converters::class)
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