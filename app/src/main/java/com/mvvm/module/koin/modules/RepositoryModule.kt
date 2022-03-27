package com.mvvm.module.koin.modules

import com.mvvm.module.data.repositoryImpl.MoviesDataRepositoryI
import com.mvvm.module.domain.repositories.IMovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { MoviesDataRepositoryI(get(), get()) as IMovieRepository }
}