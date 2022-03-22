package com.mvvm.module.koin.components

import com.mvvm.module.koin.modules.*

val applicationComponent = listOf(
    domainModule, localModule, remoteModule, repositoryModule,
    retrofitModule, viewModelModule
)