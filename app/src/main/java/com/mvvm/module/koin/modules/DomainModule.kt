package com.mvvm.module.koin.modules

import com.mvvm.module.domain.usecases.GetListMoviesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetListMoviesUseCase(get(), get(), get()) }
//    factory { GetListFeedNewsUseCase(get()) }
}
