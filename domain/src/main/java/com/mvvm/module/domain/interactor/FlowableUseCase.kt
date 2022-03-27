package com.mvvm.module.domain.interactor

import com.mvvm.module.domain.executor.IPostExecutionThread
import com.mvvm.module.domain.executor.IThreadExecutor
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

abstract class FlowableUseCase<T, in Params> constructor(
    private val IThreadExecutor: IThreadExecutor,
    private val IPostExecutionThread: IPostExecutionThread
) {

    protected abstract fun buildUseCaseObservable(params: Params? = null): Flowable<T>

    open fun execute(params: Params? = null): Flowable<T> {
        return this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(IThreadExecutor))
            .observeOn(IPostExecutionThread.scheduler)
    }
}
