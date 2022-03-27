package com.mvvm.module.data.mapper.movies

import com.mvvm.module.data.mapper.IEntityMapper
import com.mvvm.module.data.models.MovieEntity
import com.mvvm.module.domain.models.movies.Movie

class MovieIEntityMapper : IEntityMapper<MovieEntity, Movie> {
    override fun mapFromEntity(entity: MovieEntity): Movie {
        return Movie(
            id = entity.id,
            title = entity.movieTitle,
            name = entity.movieName,
            posterPath = entity.posterPath,
            profilePath = entity.profilePath,
            voteAverage = entity.voteAverage,
            isBookMarked = entity.isBookMarked
        )
    }

    override fun mapToEntity(domain: Movie): MovieEntity {
        return MovieEntity(
            id = domain.id,
            movieTitle = domain.title,
            movieName = domain.name,
            posterPath = domain.posterPath,
            profilePath = domain.profilePath,
            voteAverage = domain.voteAverage,
            isBookMarked = domain.isBookMarked
        )
    }
}