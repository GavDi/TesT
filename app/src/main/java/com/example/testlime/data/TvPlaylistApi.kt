package com.example.testlime.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TvPlaylistApi {
    @GET("api/playlist")
    suspend fun getTvPlaylists(@Header("X-Key") apiKey: String): Response<List<Any>>
}