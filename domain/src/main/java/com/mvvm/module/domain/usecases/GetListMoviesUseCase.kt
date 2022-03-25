package com.mvvm.module.domain.usecases

import com.mvvm.module.domain.executor.PostExecutionThread
import com.mvvm.module.domain.executor.ThreadExecutor
import com.mvvm.module.domain.interactor.SingleUseCase
import com.mvvm.module.domain.models.movies.Movie
import com.mvvm.module.domain.repositories.MovieRepository
import io.reactivex.Single

class GetListMoviesUseCase(
    private val movieRepository: MovieRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<Void, List<Movie>>(
    threadExecutor, postExecutionThread
) {
    public override fun buildUseCaseObservable(requestValues: Void?): Single<List<Movie>> {
        return movieRepository.getPopularMovies()
    }
}
