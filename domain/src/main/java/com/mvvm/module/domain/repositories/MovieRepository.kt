package com.mvvm.module.domain.repositories

import com.mvvm.module.domain.models.movies.Movie
import io.reactivex.Completable
import io.reactivex.Single

interface MovieRepository {
    fun getPopularMovies(): Single<List<Movie>>
//    fun getMovieCredits(movieId: Long): Single<MovieCredits>
    fun saveMovies(listMovies: List<Movie>): Completable
    fun bookmarkMovie(movieId: Long): Completable
    fun unBookmarkMovie(movieId: Long): Completable
    fun getBookMarkedMovies(): Single<List<Movie>>
}