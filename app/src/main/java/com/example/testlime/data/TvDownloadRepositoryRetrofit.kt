package com.example.testlime.data

import com.example.testlime.domain.TvDownloadRepository
import retrofit2.Retrofit
import javax.inject.Inject

class TvDownloadRepositoryRetrofit @Inject constructor (
    private val retrofit: Retrofit
): TvDownloadRepository {

    override suspend fun getData() {
        val playlistApi = retrofit.create(TvPlaylistApi::class.java)
        try {
            val apiKey = "fh3487klskhjk2fh782kjhsdi72knjwfk7i2efdjbm"
            val playlists = playlistApi.getTvPlaylists(apiKey)
            val p = playlists
            println("Received playlists: $playlists")

        } catch (e: Exception) {
            println("Хуйня, переделывай")
        }
    }

}