package com.mvvm.module.remote.repositoryImp

import com.mvvm.module.data.datasource.MovieDataStoreFactory
import com.mvvm.module.data.models.MovieEntity
import com.mvvm.module.data.repository.IMoviesRemote
import com.mvvm.module.remote.mapper.movie.MovieIRemoteMapper
import com.mvvm.module.remote.services.IMovieServiceApi
import io.reactivex.Completable
import io.reactivex.Single

class IMoviesRemoteImp (
    private val moviesService: IMovieServiceApi,
    private val movieRemoteMapper: MovieIRemoteMapper,
    private val storeFactory: MovieDataStoreFactory
) : IMoviesRemote {
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
        return moviesService.getPopularsMovies().map { movieModel ->
            movieModel.listOfMoviesResponse.map {
                movieRemoteMapper.mapFromApiResponseModel(it)
            }
        }
    }

    override fun isCached(): Single<Boolean> {
        TODO("Not yet implemented")
    }

}