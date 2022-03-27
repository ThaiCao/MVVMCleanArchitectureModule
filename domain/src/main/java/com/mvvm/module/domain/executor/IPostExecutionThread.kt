package com.mvvm.module.domain.executor

import io.reactivex.Scheduler

interface IPostExecutionThread {
    val scheduler: Scheduler
}