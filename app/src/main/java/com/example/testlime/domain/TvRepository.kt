package com.example.testlime.domain

import androidx.lifecycle.LiveData

interface TvRepository {

    fun getLocalData() : LiveData<List<Tv>>

}