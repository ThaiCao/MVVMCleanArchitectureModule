package com.mvvm.module.remote.services

import com.mvvm.module.remote.models.MovieListModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IMovieServiceApi {

    @GET("movie/popular")
    fun getPopularsMovies(): Single<MovieListModel>

//    @GET("movie/{movie_id}/credits")
//    fun getMoviesCredits(@Path("movie_id") movieId: Int): Single<MovieCreditsModel>
}