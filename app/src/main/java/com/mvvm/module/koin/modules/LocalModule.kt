package com.mvvm.module.koin.modules

import com.mvvm.module.data.store.MoviesCache
import com.mvvm.module.local.db.AppDatabase
import com.mvvm.module.local.implementation.MoviesCacheImp
import com.mvvm.module.local.mapper.movies.MovieCacheMapper
import com.mvvm.module.local.sharedPreferences.SharedPrefUtils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { AppDatabase.buildDatabase(androidContext())}
    factory { MoviesCacheImp(get(), get(), get()) as MoviesCache}
    factory { MovieCacheMapper() }
    factory { SharedPrefUtils(get()) }

}