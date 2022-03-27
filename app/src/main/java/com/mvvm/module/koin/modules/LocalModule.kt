package com.mvvm.module.koin.modules

import com.mvvm.module.data.repository.IMoviesCache
import com.mvvm.module.local.db.AppDatabase
import com.mvvm.module.local.repositoryImpl.IMoviesCacheImp
import com.mvvm.module.local.mapper.movies.MovieCacheMapper
import com.mvvm.module.local.sharedPreferences.SharedPrefUtils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { AppDatabase.buildDatabase(androidContext())}
    factory { IMoviesCacheImp(get(), get(), get()) as IMoviesCache}
    factory { MovieCacheMapper() }
    factory { SharedPrefUtils(get()) }

}