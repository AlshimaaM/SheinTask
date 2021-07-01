package com.example.sheintask.data.remote.retrofit

import com.example.sheintask.data.SheinHome
import com.example.sheintask.data.SheinProductDetails
import retrofit2.Response
import retrofit2.http.*


interface SheinApi {

    @GET("home-page")
    suspend fun getSheinProduct(): Response<SheinHome>

    @POST("product-detalis")
    suspend fun getProductById(@Query("product_id") id:Int): Response<SheinProductDetails>

}