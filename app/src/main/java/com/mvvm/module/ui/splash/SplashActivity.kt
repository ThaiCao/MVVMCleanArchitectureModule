package com.mvvm.module.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mvvm.module.R
import com.mvvm.module.ui.movielist.activity.MovieListActivity
import com.mvvm.module.utils.common.NavigationUtils

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            NavigationUtils.navigateToMovieListActivity(this)
            finish()
        }, DELAY_IN_IN_TRANSITION)
    }

    companion object {
        private const val DELAY_IN_IN_TRANSITION = 2000L
    }
}