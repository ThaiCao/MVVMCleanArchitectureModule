package com.mvvm.module.domain.usecases

import com.mvvm.module.domain.executor.IPostExecutionThread
import com.mvvm.module.domain.executor.IThreadExecutor
import com.mvvm.module.domain.interactor.SingleUseCase
import com.mvvm.module.domain.models.movies.Movie
import com.mvvm.module.domain.repositories.IMovieRepository
import io.reactivex.Single

class GetListMoviesUseCase(
    private val IMovieRepository: IMovieRepository,
    IThreadExecutor: IThreadExecutor,
    IPostExecutionThread: IPostExecutionThread
) : SingleUseCase<Void, List<Movie>>(
    IThreadExecutor, IPostExecutionThread
) {
    public override fun buildUseCaseObservable(requestValues: Void?): Single<List<Movie>> {
        return IMovieRepository.getPopularMovies()
    }
}
