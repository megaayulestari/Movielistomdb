package com.example.movielistomdb.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieModel(
    val Year: String,
    val Title: String,
    @SerialName("Poster") val gambar: String
)
