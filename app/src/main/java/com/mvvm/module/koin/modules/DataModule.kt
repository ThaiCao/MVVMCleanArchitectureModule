package com.mvvm.module.koin.modules

import com.mvvm.module.data.mapper.movies.MovieEntityMapper
import com.mvvm.module.data.store.MoviesCache
import com.mvvm.module.domain.usecases.GetListMoviesUseCase
import com.mvvm.module.local.mapper.movies.MovieCacheMapper
import org.koin.dsl.module

val dataModule = module {
    factory { MovieEntityMapper() }
}
