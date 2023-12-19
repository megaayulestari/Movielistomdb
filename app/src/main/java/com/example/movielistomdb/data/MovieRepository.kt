package com.example.movielistomdb.data

import com.example.movielistomdb.model.MovieModel
import com.example.movielistomdb.network.MovieApiService

interface MovieRepository {
    suspend fun getMovieModel(): List<MovieModel>
}

class NetworkMovieRepository(
    private val MovieApiService: MovieApiService
) : MovieRepository {
    override suspend fun getMovieModel(): List<MovieModel> = MovieApiService.getMovies()

}
