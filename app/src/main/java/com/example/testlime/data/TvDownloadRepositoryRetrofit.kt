package com.example.testlime.data

import com.example.testlime.domain.TvDownloadRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
            val response  = playlistApi.getTvPlaylists(apiKey)

            if (response.isSuccessful) {
                if (response.body() != null) {
                    val playlists = response.body()?.channels ?: emptyList()

                    CoroutineScope(Dispatchers.IO).launch {
                        val favouriteTvListMap = tvDao.getTvNamesAndFavourites().associateBy { it.name_ru }
                        val tvDbEntityList = playlists.map { it ->
                            val favouriteTv = favouriteTvListMap[it.name_ru]
                            it.fromTvToTvDbEntity(isFavourite = favouriteTv?.is_favourite ?: false)
                        }
                        tvDao.insertAll(tvDbEntityList)
                    }
                }else {
                    println("TvDownloadRepositoryRetrofit Response body is null: ${response.body()}")}
            }else {
                println("TvDownloadRepositoryRetrofit Response is not successful: ${response.code()}")
            }
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