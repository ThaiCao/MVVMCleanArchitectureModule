package com.mvvm.module.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    protected val compositeDisposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposables.dispose()
    }
}

fun Disposable.addTo(compositeDisposables: CompositeDisposable) {
    compositeDisposables.add(this)
}

