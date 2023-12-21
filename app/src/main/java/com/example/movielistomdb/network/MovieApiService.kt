package com.example.movielistomdb.network

import com.example.movielistomdb.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("albums")
    suspend fun getMovies(
    ): List<MovieModel>
}