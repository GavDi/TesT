package com.example.testlime.domain

import java.io.Serializable

data class Tv(
    val id: Int,
    val name_ru: String,
    val image: String,
    val url: String,
    val isFavorite: Boolean
) : Serializable
