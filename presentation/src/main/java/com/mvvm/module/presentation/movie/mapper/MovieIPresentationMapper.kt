package com.mvvm.module.presentation.movie.mapper

import com.mvvm.module.domain.models.movies.Movie
import com.mvvm.module.presentation.mapper.IPresentationMapper
import com.mvvm.module.presentation.movie.models.MoviePresentation

class MovieIPresentationMapper : IPresentationMapper<MoviePresentation, Movie> {
    override fun mapToPresentation(domain: Movie): MoviePresentation {
        return MoviePresentation(
            id = domain.id,
            movieName=  domain.name,
            voteAverage = domain.voteAverage,
            profilePath = domain.profilePath,
            isBookMarked = domain.isBookMarked
        )

        //  var id: Long? = 0,
        //    var movieName: String? = "",
        //    var voteAverage: Double? = 0.0,
        //    var profilePath: String? = "",
        //    var isBookMarked: Boolean
    }

}