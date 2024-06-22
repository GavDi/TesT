package com.example.testlime.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testlime.domain.TvDownloadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvViewModel @Inject constructor (
    private val tvDownloadRepository: TvDownloadRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            tvDownloadRepository.getData()
        }
    }

    fun getTvLiveData(): Int = 1

}