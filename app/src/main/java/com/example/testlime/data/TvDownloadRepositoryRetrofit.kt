package com.example.testlime.data

import com.example.testlime.domain.TvDownloadRepository
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject

class TvDownloadRepositoryRetrofit @Inject constructor (
    private val retrofit: Retrofit,
    private val tvDao: TvDao
): TvDownloadRepository {

    override suspend fun getData() {
        val playlistApi = retrofit.create(TvPlaylistApi::class.java)
        try {
            val apiKey = "fh3487klskhjk2fh782kjhsdi72knjwfk7i2efdjbm"
            val playlists = playlistApi.getTvPlaylists(apiKey)
            val p = playlists
        } catch (e: HttpException) {
            println("TvDownloadRepositoryRetrofit HTTP exception occurred: ${e.message()}")
            e.printStackTrace()
        } catch (e: IOException) {
            println("TvDownloadRepositoryRetrofit Network or conversion error occurred: ${e.message}")
            e.printStackTrace()
        } catch (e: Exception) {
            println("TvDownloadRepositoryRetrofit Unknown error occurred: ${e.message}")
            e.printStackTrace()
        }
    }

}