package com.example.movielistomdb.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieModel(
    val id: Int,
    val title: String,
)

