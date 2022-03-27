package com.mvvm.module.presentation.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvvm.module.domain.models.movies.Movie
import com.mvvm.module.domain.usecases.GetListMoviesUseCase
import com.mvvm.module.presentation.base.BaseViewModel
import com.mvvm.module.presentation.movie.mapper.MovieIPresentationMapper
import com.mvvm.module.presentation.movie.models.MoviePresentation
import com.mvvm.module.presentation.state.Resource
import com.mvvm.module.presentation.state.Status
import io.reactivex.observers.DisposableSingleObserver

class MovieListViewModel(
    private val getListMoviesUseCase: GetListMoviesUseCase,
    private val mapper: MovieIPresentationMapper
) : BaseViewModel() {

    private val movieListMutableLiveData: MutableLiveData<Resource<List<MoviePresentation>>> = MutableLiveData()

    fun getMovieListLiveData(): LiveData<Resource<List<MoviePresentation>>> {
        return movieListMutableLiveData
    }

    fun fetchMovieList() {
        movieListMutableLiveData.postValue(Resource(Status.LOADING, null, null))
        val singleObserver = object : DisposableSingleObserver<List<Movie>>() {
            override fun onSuccess(item: List<Movie>) {
                movieListMutableLiveData.postValue(
                    Resource(
                        Status.SUCCESS,
                        item.map { domain -> mapper.mapToPresentation(domain) }, null
                    )
                )
            }

            override fun onError(e: Throwable) {
                movieListMutableLiveData.postValue(Resource(Status.ERROR, null, e.localizedMessage))
            }
        }
        getListMoviesUseCase.execute(singleObserver)
    }

    override fun onCleared() {
        getListMoviesUseCase.dispose()
        super.onCleared()
    }

}