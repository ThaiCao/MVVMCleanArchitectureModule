package com.mvvm.module.koin.modules

import com.mvvm.module.data.datasource.IMovieCacheDataSource
import com.mvvm.module.data.datasource.MovieDataStoreFactory
import com.mvvm.module.data.datasource.IMovieRemoteDataSource
import com.mvvm.module.data.repository.IMoviesRemote
import com.mvvm.module.remote.mapper.movie.MovieIRemoteMapper
import com.mvvm.module.remote.repositoryImp.IMoviesRemoteImp
import org.koin.dsl.module

val remoteModule = module {
    factory { MovieIRemoteMapper() }
    factory { IMoviesRemoteImp(get(), get(), get()) as IMoviesRemote }
}