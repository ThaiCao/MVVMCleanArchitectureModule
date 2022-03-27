package com.mvvm.module.koin.modules

import com.mvvm.module.data.mapper.movies.MovieEntityMapper
import com.mvvm.module.data.repository.MoviesDataRepository
import com.mvvm.module.domain.repositories.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { MoviesDataRepository(get(), get()) as MovieRepository }
}