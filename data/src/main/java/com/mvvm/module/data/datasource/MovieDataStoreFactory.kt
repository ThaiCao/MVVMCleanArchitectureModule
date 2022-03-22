package com.mvvm.module.data.datasource

import com.mvvm.module.data.store.MovieDataStore
import com.mvvm.module.data.store.MoviesCache

open class MovieDataStoreFactory(
    private val moviesCache: MoviesCache,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource) {

    open fun getDataStore(isCached: Boolean): MovieDataStore {
        if (isCached && !moviesCache.isExpired()) {
            return getCacheDataStore()
        }
        return getRemoteDataStore()
    }

    fun getCacheDataStore(): MovieDataStore {
        return movieCacheDataSource
    }

    fun getRemoteDataStore(): MovieDataStore {
        return movieRemoteDataSource
    }
}