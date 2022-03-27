package com.mvvm.module.ui.movielist.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.mvvm.module.R
import com.mvvm.module.base.BaseActivity
import com.mvvm.module.ui.movielist.fragment.MovieListFragment
import com.mvvm.module.utils.common.ActivityUtils

class MovieListActivity : BaseActivity() {

    private var movieListFragment: MovieListFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        movieListFragment = MovieListFragment.newInstance(intent.extras)
        ActivityUtils.addFragmentToActivityWithTag(
            supportFragmentManager,
            movieListFragment!!, R.id.fragment_container, MovieListFragment.javaClass.name
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(from: Context): Intent =
            Intent(from, MovieListActivity::class.java).apply {
                putExtras(Bundle().apply {

                })
            }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}