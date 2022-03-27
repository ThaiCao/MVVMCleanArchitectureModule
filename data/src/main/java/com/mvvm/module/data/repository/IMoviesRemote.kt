package com.mvvm.module.data.repository

import com.mvvm.module.data.models.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

interface IMoviesRemote {
    fun getBookMarkedMovies(): Single<List<MovieEntity>>
    fun setMovieBookmarked(movieId: Long): Completable
    fun setMovieUnBookMarked(movieId: Long): Completable
    fun saveMovies(listMovies: List<MovieEntity>): Completable
    fun getPopularMovies(): Single<List<MovieEntity>>
//    fun getMoviesCredits(movieId: Long): Single<MovieCreditEntity>
    fun isCached(): Single<Boolean>
}