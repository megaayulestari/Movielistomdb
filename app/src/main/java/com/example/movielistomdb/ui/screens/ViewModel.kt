package com.example.movielistomdb.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.movielistomdb.MovieApplication
import com.example.movielistomdb.data.MovieRepository
import com.example.movielistomdb.model.MovieModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MovieUiState{
    data class Success(val movie: List<MovieModel>) : MovieUiState
    object Error : MovieUiState
    object Loading : MovieUiState
}

class ViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    var movieUiState: MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    init {
        getMovieModel()
    }

    fun getMovieModel() {
        viewModelScope.launch {
            movieUiState = MovieUiState.Loading
            movieUiState = try {
                //val result = marsPhotosRepository.getMarsPhotos()[0]
                MovieUiState.Success(movieRepository.getMovieModel())
                //MarsUiState.Success(
                //"Success: ${listResult.size} Mars photos retrieved"
                //    "   First Mars image URL : ${result.imgSrc}"
                //)
            } catch (e: IOException) {
                MovieUiState.Error
            } catch (e: HttpException) {
                MovieUiState.Error
            }
        }
    }

    companion object {
        //const val API_KEY = "e77d5897"
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieApplication)
                val movieRepository = application.container.movieRepository
                ViewModel(movieRepository = movieRepository)
            }
        }
    }
}
