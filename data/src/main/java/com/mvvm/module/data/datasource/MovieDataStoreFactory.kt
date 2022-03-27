package com.mvvm.module.data.datasource

import com.mvvm.module.data.repository.IMovieDataStore
import com.mvvm.module.data.repository.IMoviesCache

open class MovieDataStoreFactory(
    private val IMoviesCache: IMoviesCache,
    private val movieCacheDataSource: IMovieCacheDataSource,
    private val movieRemoteDataSource: IMovieRemoteDataSource) {

    open fun getDataStore(isCached: Boolean): IMovieDataStore {
        if (isCached && !IMoviesCache.isExpired()) {
            return getCacheDataStore()
        }
        return getRemoteDataStore()
    }

    fun getCacheDataStore(): IMovieDataStore {
        return movieCacheDataSource
    }

    fun getRemoteDataStore(): IMovieDataStore {
        return movieRemoteDataSource
    }
}