package com.example.testlime.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testlime.domain.Tv
import com.example.testlime.domain.TvDownloadRepository
import com.example.testlime.domain.TvRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvViewModel @Inject constructor (
    private val tvDownloadRepository: TvDownloadRepository,
    private val tvRepository: TvRepository
) : ViewModel() {

    private var tvLiveData: LiveData<List<Tv>> = tvRepository.getLocalData()

    init {
        viewModelScope.launch {
            tvDownloadRepository.getData()
        }
    }

    fun getTvLiveData(): LiveData<List<Tv>> = tvLiveData

}