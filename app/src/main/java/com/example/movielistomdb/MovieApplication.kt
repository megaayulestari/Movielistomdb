package com.example.movielistomdb

import android.app.Application
import com.example.movielistomdb.data.AppContainer
import com.example.movielistomdb.data.DefaultAppContainer

class MovieApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}