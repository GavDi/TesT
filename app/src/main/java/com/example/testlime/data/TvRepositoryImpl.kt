package com.example.testlime.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.testlime.domain.Tv
import com.example.testlime.domain.TvRepository
import javax.inject.Inject

class TvRepositoryImpl @Inject constructor (
    private val tvDao: TvDao
) : TvRepository {

    override fun getLocalData() : LiveData<List<Tv>> = tvDao.getTVListAll()
        .map { list -> list.map { it.toTvDb() }  }

}

