package com.mvvm.module.local.implementation

import com.mvvm.module.data.models.MovieEntity
import com.mvvm.module.data.store.MoviesCache
import com.mvvm.module.local.db.AppDatabase
import com.mvvm.module.local.mapper.movies.MovieCacheMapper
import com.mvvm.module.local.sharedPreferences.SharedPrefUtils
import io.reactivex.Completable
import io.reactivex.Single

class MoviesCacheImp(
    private val appDatabase: AppDatabase,
    private val movieCacheMapper: MovieCacheMapper,
    private val sharedPrefUtils: SharedPrefUtils
) : MoviesCache {
    override fun getPopularMovies(): Single<List<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun saveMovies(listMovies: List<MovieEntity>): Completable {
        TODO("Not yet implemented")
    }

    override fun getBookMarkedMovies(): Single<List<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun setMovieBookmarked(movieId: Long): Completable {
        TODO("Not yet implemented")
    }

    override fun setMovieUnBookMarked(movieId: Long): Completable {
        TODO("Not yet implemented")
    }

    override fun isCached(): Single<Boolean> {
        TODO("Not yet implemented")
    }

    override fun setLastCacheTime(lastCache: Long) {
        TODO("Not yet implemented")
    }

    override fun isExpired(): Boolean {
        TODO("Not yet implemented")
    }
}