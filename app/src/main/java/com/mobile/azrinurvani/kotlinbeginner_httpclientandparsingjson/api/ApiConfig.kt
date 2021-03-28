package com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    //GANTI URL sesuai dengan network anda!
    const val BASE_URL = "http://192.168.43.117:8080/bk_blog_api/index.php/Server/"

    fun config(): Retrofit{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun service():ApiService{
        return config().create(ApiService::class.java)
    }

}