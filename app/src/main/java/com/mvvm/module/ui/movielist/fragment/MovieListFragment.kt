package com.mvvm.module.ui.movielist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.module.R
import com.mvvm.module.base.BaseFragment
import com.mvvm.module.databinding.FragmentMovieListBinding
import com.mvvm.module.remote.mapper.MovieUiMapper
import com.mvvm.module.model.MovieUi
import com.mvvm.module.presentation.movie.models.MoviePresentation
import com.mvvm.module.presentation.movie.viewmodel.MovieListViewModel
import com.mvvm.module.presentation.state.Resource
import com.mvvm.module.presentation.state.Status
import com.mvvm.module.ui.movielist.adapter.MovieListRecyclerViewAdapter
import com.mvvm.module.ui.movielist.listener.OnMovieItemClickListener
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment() {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MovieListViewModel by viewModel()
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val uiMapper: MovieUiMapper by inject()


    private var adapter: MovieListRecyclerViewAdapter = MovieListRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        _binding?.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        handleListener()
        handleCallback()
        viewModel.fetchMovieList()
    }

    private fun initView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = adapter
        adapter.setItemClickListener(venueClickListener)
    }

    private fun handleListener(){

    }

    private fun handleCallback(){
        viewModel.getMovieListLiveData().observe(viewLifecycleOwner){
            handleMovieListResourceStatus(it)
        }
    }

    private fun handleMovieListResourceStatus(dataResource: Resource<List<MoviePresentation>>){
        when (dataResource.status) {
            Status.LOADING -> {
                binding.vProgress.visibility = View.VISIBLE
            }
            Status.SUCCESS -> {
                binding.vProgress.visibility = View.GONE
                val movieUi = dataResource.data?.map { uiMapper.mapToUi(it) } ?: emptyList()

                adapter.setData(movieUi)

                if (movieUi.isEmpty()) {

                }
            }
            Status.ERROR -> {
                binding.vProgress.visibility = View.GONE
            }
            Status.INIT -> {
                binding.vProgress.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        _binding = null
    }

    private val venueClickListener = object : OnMovieItemClickListener {

        override fun onMovieItemClicked(movie: MovieUi) {
        }

    }

    companion object {
        fun newInstance(args: Bundle?) = MovieListFragment().apply {
            arguments = args
        }
    }
}