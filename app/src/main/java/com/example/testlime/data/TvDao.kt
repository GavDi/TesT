package com.example.testlime.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TvDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tvList: List<TvDbEntity>)

    @Query("SELECT * FROM tvs")
    fun getTVListAll(): LiveData<List<TvDbEntity>>

}