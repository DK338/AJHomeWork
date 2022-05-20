package com.example.ajhomework.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ajhomework.repositories.DatasRepository
import com.example.ajhomework.responses.DataResponse

class DataResponseViewModel : ViewModel() {
    
    var datasRepository: DatasRepository = DatasRepository()

    fun getDataResponses(): LiveData<DataResponse>? = datasRepository.getDataResponses()


}