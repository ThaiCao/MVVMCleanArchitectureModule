package com.mvvm.module.remote.mapper

import com.mvvm.module.model.MovieUi
import com.mvvm.module.presentation.movie.models.MoviePresentation

class MovieUiMapper : UiMapper<MoviePresentation, MovieUi> {

    override fun mapToUi(presentation: MoviePresentation): MovieUi {
        return MovieUi(
            id = presentation.id,
            movieName=  presentation.movieName,
            voteAverage = presentation.voteAverage,
            profilePath = presentation.profilePath,
            isBookMarked = presentation.isBookMarked
        )
    }

}