package com.mvvm.module.utils.common

import android.content.Context
import com.mvvm.module.ui.movielist.activity.MovieListActivity

object NavigationUtils {
    fun navigateToMovieListActivity(context: Context?) {
        context?.startActivity(MovieListActivity.newInstance(context))
    }

}