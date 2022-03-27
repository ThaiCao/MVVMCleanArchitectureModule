package com.mvvm.module.ui.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.module.databinding.ItemMovieListBinding
import com.mvvm.module.model.MovieUi
import com.mvvm.module.ui.movielist.listener.OnMovieItemClickListener

class MovieListRecyclerViewAdapter : RecyclerView.Adapter<MovieListRecyclerViewAdapter.BindingViewHolder>(){

    private var dataList: List<MovieUi> = ArrayList()

    private var itemClickListener: OnMovieItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieListBinding.inflate(inflater, parent, false)

        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) = holder.bind(dataList[position])

    override fun getItemCount(): Int = dataList.count()

    fun setData(newDataList: List<MovieUi>) {
        dataList = newDataList
        notifyDataSetChanged()
    }

    fun setItemClickListener(newListener: OnMovieItemClickListener) {
        itemClickListener = newListener
    }


    inner class BindingViewHolder(private var binding: ItemMovieListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieUi) {

            binding.root.setOnClickListener {
                itemClickListener?.onMovieItemClicked(movie)
            }

            binding.movie = movie

            binding.executePendingBindings()
        }

    }
}