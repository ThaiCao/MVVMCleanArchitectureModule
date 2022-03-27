package com.mvvm.module.remote.mapper.movie

import com.mvvm.module.data.models.MovieEntity
import com.mvvm.module.remote.mapper.IRemoteMapper
import com.mvvm.module.remote.models.MovieModel

class MovieIRemoteMapper : IRemoteMapper<MovieModel, MovieEntity> {

    override fun mapFromApiResponseModel(model: MovieModel): MovieEntity {
        return MovieEntity(
            id = model.id,
            movieTitle = model.title,
            movieName = model.name,
            posterPath = model.posterPath,
            profilePath = model.profilePath,
            voteAverage = model.voteAverage,
            isBookMarked = false
        )
    }

}