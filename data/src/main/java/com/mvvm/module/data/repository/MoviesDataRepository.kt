package com.mvvm.module.data.repository

import com.mvvm.module.data.datasource.MovieDataStoreFactory
import com.mvvm.module.data.mapper.movies.MovieEntityMapper
import com.mvvm.module.domain.models.movies.Movie
import com.mvvm.module.domain.repositories.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single

class MoviesDataRepository(
    private val movieMapper: MovieEntityMapper,
//    private val movieCreditMapper: MovieCreditMapper,
    private val movieDataStoreFactory: MovieDataStoreFactory
) : MovieRepository {

    override fun getPopularMovies(): Single<List<Movie>> {
        return movieDataStoreFactory.getCacheDataStore().isCached()
            .flatMap {
                movieDataStoreFactory.getDataStore(it).getPopularMovies()
            }
            .flatMap {
                Single.just(it.map { movieMapper.mapFromEntity(it) })
            }
            .flatMap {
                saveMovies(it).toSingle { it }
            }
    }

    override fun saveMovies(listMovies: List<Movie>): Completable {
        return movieDataStoreFactory.getCacheDataStore().saveMovies(
            listMovies.map { movieMapper.mapToEntity(it) }
        )
    }

    override fun bookmarkMovie(movieId: Long): Completable {
        return movieDataStoreFactory.getCacheDataStore().setMovieBookmarked(movieId)
    }

    override fun unBookmarkMovie(movieId: Long): Completable {
        return movieDataStoreFactory.getCacheDataStore().setMovieUnBookMarked(movieId)
    }

    override fun getBookMarkedMovies(): Single<List<Movie>> {
        return movieDataStoreFactory.getCacheDataStore().getBookMarkedMovies()
            .map { listOfMovieEntities ->
                listOfMovieEntities.map { movieMapper.mapFromEntity(it) }
            }
    }
}