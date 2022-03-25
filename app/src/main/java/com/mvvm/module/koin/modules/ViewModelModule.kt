package com.mvvm.module.koin.modules

import com.mvvm.module.presentation.movie.viewmodel.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
/*
    single {
        AppDispatchers(Dispatchers.Main, Dispatchers.IO, Dispatchers.Default)
    }

    viewModel {
        FeedViewModel(get(), get())
    }

    viewModel {
        FeedDetailViewModel()
    }*/

    viewModel {
        MovieListViewModel(get(), get())
    }
}