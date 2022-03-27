package com.mvvm.module.data.datasource

import com.mvvm.module.data.models.MovieEntity
import com.mvvm.module.data.repository.IMovieDataStore
import com.mvvm.module.data.repository.IMoviesRemote
import io.reactivex.Completable
import io.reactivex.Single

class IMovieRemoteDataSource(private val IMoviesRemote: IMoviesRemote) : IMovieDataStore {
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