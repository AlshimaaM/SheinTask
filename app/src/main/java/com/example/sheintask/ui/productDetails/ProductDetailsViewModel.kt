package com.example.sheintask.ui.productDetails

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sheintask.data.DataProduct
import com.example.sheintask.data.remote.repo.ApiRepository
import kotlinx.coroutines.launch

class ProductDetailsViewModel(application: Application) : AndroidViewModel(application) {
    var apiRepository: ApiRepository
    var product  = MutableLiveData<DataProduct>()

    init{
        apiRepository = ApiRepository(application)
    }

    fun getProductById(id:Int) {
        viewModelScope.launch {
            val response=apiRepository.getProductById(id)
            product.postValue(response?.data)
        }
    }
}