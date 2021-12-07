package com.darothub.threadingexample

import android.app.Application
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainApp: Application() {
    lateinit var newThread2: Thread
    override fun onCreate() {
        super.onCreate()
//        newThread2 = thread {
//            for (i in 10 downTo 0){
//                println("Count $i")
//                try {
//                    TimeUnit.SECONDS.sleep(3)
//                }
//                catch (e:Exception){
//                    println("${e.message}")
//                }
//            }
//            Log.d("NewMainThread2", "${Thread.currentThread()}")
//        }
    }
    companion object{
        fun getRetrofit(): DataService{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(DataService::class.java)
        }
        fun getDataRepository():DataRepository{
            return DataRepository(getRetrofit())
        }
    }
}