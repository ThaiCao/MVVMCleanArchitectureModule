package com.mvvm.module.presentation.movie.models

data class MoviePresentation(
    var id: Long? = 0,
    var movieName: String? = "",
    var voteAverage: Double? = 0.0,
    var profilePath: String? = "",
    var isBookMarked: Boolean
)
