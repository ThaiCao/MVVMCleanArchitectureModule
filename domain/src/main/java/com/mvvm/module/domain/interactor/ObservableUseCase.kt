package com.mvvm.module.domain.interactor

import com.mvvm.module.domain.executor.IPostExecutionThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<T, in Params> constructor(
    private val IPostExecutionThread: IPostExecutionThread
) {

    private val disposables = CompositeDisposable()

    protected abstract fun doWork(params: Params? = null): Observable<T>

    open fun execute(singleObserver: DisposableObserver<T>, params: Params? = null) {
        val single = this.doWork(params)
            .subscribeOn(Schedulers.io())
            .observeOn(IPostExecutionThread.scheduler)
        addDisposable(single.subscribeWith(singleObserver))
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun clear() {
        if (!disposables.isDisposed) disposables.dispose()
    }
}
