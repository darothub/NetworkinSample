package com.darothub.threadingexample

import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository(private var dataService: DataService) {

    fun getRemoteData(remoteResponse: RemoteResponse) {
        remoteResponse.onProgress()
        dataService.getData().enqueue(object : Callback<DataClass>{
            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                remoteResponse.onSuccessful(response)
//                activity.findViewById<TextView>(R.id.text_view).text = response.body().toString()
                Log.d("Main", response.body().toString())
            }

            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                remoteResponse.onFailure(t)
                Log.d("Main", t.message.toString())
            }

        })
    }
}

interface RemoteResponse{
    fun onSuccessful(response: Response<DataClass>)
    fun onFailure( t: Throwable)
    fun onProgress()
}