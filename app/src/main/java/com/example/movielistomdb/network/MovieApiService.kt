package com.example.movielistomdb.network

import com.example.movielistomdb.model.MovieModel
import retrofit2.http.GET

interface MovieApiService {
    @GET("?s=thor&apikey=e77d5897")
    suspend fun getMovies(): List<MovieModel>
}