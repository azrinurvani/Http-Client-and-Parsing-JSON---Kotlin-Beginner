package com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.api

import com.mobile.azrinurvani.kotlinbeginner_httpclientandparsingjson.model.ResponseArtikel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("getAllDataBlog")
    fun getAllArtikel(): Call<ResponseArtikel>
}