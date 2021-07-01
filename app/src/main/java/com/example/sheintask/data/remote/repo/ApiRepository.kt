package com.example.sheintask.data.remote.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sheintask.data.SheinHome
import com.example.sheintask.data.SheinProductDetails
import com.example.sheintask.data.remote.retrofit.ApiServes

class ApiRepository(application: Application) {
    var apihomeProduct = MutableLiveData<SheinHome>()

    suspend fun fetchHomeProduct() {
        val response = ApiServes.sheinService.getSheinProduct()
        try {
            if (response.isSuccessful) {
                response.body()?.let {
                    apihomeProduct.postValue(it)
                }
            } else {
                Log.i("ApiRepository", "response failuer" + response.errorBody().toString())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("ApiRepository", " error?" + e.printStackTrace())

        }

    }

    suspend fun getProductById(id: Int): SheinProductDetails? {
        Log.i("ApiRepository","  orderrrrrr"+ id)
        val response = ApiServes.sheinService.getProductById(id)
        try {
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.i("ApiRepository", "response" + it)
                    return it
                }
            } else {
                Log.i("ApiRepository", "response failuer" + response.errorBody().toString())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("ApiRepository", " error?" + e.printStackTrace())
        }
        return null
    }



}




