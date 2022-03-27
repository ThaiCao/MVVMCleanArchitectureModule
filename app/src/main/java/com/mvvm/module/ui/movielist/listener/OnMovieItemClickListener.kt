package com.mvvm.module.ui.movielist.listener

import com.mvvm.module.model.MovieUi

interface OnMovieItemClickListener {
    fun onMovieItemClicked(movie: MovieUi)
}