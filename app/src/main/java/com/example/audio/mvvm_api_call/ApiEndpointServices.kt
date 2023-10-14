package com.example.audio.mvvm_api_call

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiEndpointServices {

    @FormUrlEncoded
    @POST(".")
    suspend fun getPropertyList(@Field("") name:String): ResponseModelClass

    companion object{
        fun apiCilent():ApiEndpointServices{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://spribe.utwebapps.com/ajax/mapi.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return  retrofit.create(ApiEndpointServices::class.java)
        }
    }
}