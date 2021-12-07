package com.darothub.threadingexample

import retrofit2.Call
import retrofit2.http.GET
const val BASE_URL = "https://reqres.in/api/"
interface DataService {
    @GET("products")
    fun getData(): Call<DataClass>
}
