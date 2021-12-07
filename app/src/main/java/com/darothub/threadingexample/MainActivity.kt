package com.darothub.threadingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), RemoteResponse {
    lateinit var textView: TextView
    lateinit var dataRepository: DataRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_view)

        findViewById<Button>(R.id.btn).setOnClickListener {

//            MainApp.getRetrofit().getData().enqueue(object : Callback<DataClass>{
//                override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
//                    textView.text = response.body()?.totalPages.toString()
//                    Log.d("Main", response.body().toString())
//                }
//
//                override fun onFailure(call: Call<DataClass>, t: Throwable) {
//                    Log.d("Main", t.message.toString())
//                }
//
//            })
            MainApp.getDataRepository().getRemoteData(this)
        }


    }

    override fun onSuccessful(response: Response<DataClass>) {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        textView.text = response.body().toString()
    }

    override fun onFailure(t: Throwable) {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        textView.text = t.message.toString()
    }

    override fun onProgress() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
    }
}
