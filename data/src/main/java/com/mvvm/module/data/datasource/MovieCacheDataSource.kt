package com.mvvm.module.data.datasource

import com.mvvm.module.data.models.MovieEntity
import com.mvvm.module.data.store.MovieDataStore
import com.mvvm.module.data.store.MoviesCache
import io.reactivex.Completable
import io.reactivex.Single

class MovieCacheDataSource(private val moviesCache: MoviesCache) : MovieDataStore {
    override fun getBookMarkedMovies(): Single<List<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun setMovieBookmarked(movieId: Long): Completable {
        TODO("Not yet implemented")
    }

    override fun setMovieUnBookMarked(movieId: Long): Completable {
        TODO("Not yet implemented")
    }

    override fun saveMovies(listMovies: List<MovieEntity>): Completable {
        TODO("Not yet implemented")
    }

    override fun getPopularMovies(): Single<List<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun isCached(): Single<Boolean> {
        TODO("Not yet implemented")
    }
}