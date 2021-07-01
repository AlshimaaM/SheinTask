package com.example.sheintask.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.sheintask.data.SheinHome
import com.example.sheintask.data.remote.repo.ApiRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    var apiRepository: ApiRepository

    init{
        apiRepository = ApiRepository(application)
    }
    fun loadData(): MutableLiveData<SheinHome> {
        viewModelScope.launch {
            apiRepository.fetchHomeProduct()
        }
        return apiRepository.apihomeProduct
    }
}