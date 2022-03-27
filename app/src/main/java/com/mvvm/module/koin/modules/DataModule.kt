package com.mvvm.module.koin.modules

import com.mvvm.module.data.datasource.IMovieCacheDataSource
import com.mvvm.module.data.datasource.IMovieRemoteDataSource
import com.mvvm.module.data.datasource.MovieDataStoreFactory
import com.mvvm.module.data.mapper.movies.MovieIEntityMapper
import org.koin.dsl.module

val dataModule = module {
    factory { MovieIEntityMapper() }
    factory { IMovieRemoteDataSource(get()) }
    factory { IMovieCacheDataSource(get()) }
    factory { MovieDataStoreFactory(get(), get(), get()) }
}
