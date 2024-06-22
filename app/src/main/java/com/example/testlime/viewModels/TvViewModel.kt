package com.example.testlime.viewModels

import androidx.lifecycle.ViewModel

//@HiltViewModel
class TvViewModel /*@Inject constructor (
    private val tvDownloadRepository: TvDownloadRepository*/
    () : ViewModel() {

    init {
        //viewModelScope.launch {
       //     tvDownloadRepository.getData()
        //}
    }

    fun getTvLiveData(): Int = 1

}