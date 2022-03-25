package com.mvvm.module.presentation.movie.mapper

import com.mvvm.module.domain.models.movies.Movie
import com.mvvm.module.presentation.mapper.PresentationMapper
import com.mvvm.module.presentation.movie.models.MovieView

class MoviePresentationMapper : PresentationMapper<MovieView, Movie> {
    override fun mapToPresentation(domain: Movie): MovieView {
        return MovieView(
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