package com.mvvm.module.koin.modules

import com.mvvm.module.data.datasource.MovieCacheDataSource
import com.mvvm.module.data.datasource.MovieDataStoreFactory
import com.mvvm.module.data.datasource.MovieRemoteDataSource
import org.koin.dsl.module

val remoteModule = module {
    factory { MovieRemoteDataSource(get()) }
    factory { MovieCacheDataSource(get()) }
    factory { MovieDataStoreFactory(get(), get(), get()) }
}