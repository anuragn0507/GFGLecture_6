package com.anurag.gfglecture_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CRUD operation -> Create, Read, Update, Delete
        //post request -> title , body , userId(200)
        // Response -> Success -> id, title , body, userId
        //             Error -> "There was an error

        // Main thread (UI thread)
        // I/o heavy tasks -> Background thread(I/o thread)
        // Room DataBase

        /*val postRequest = RetrofitService.retrofitInstance.postData("Title", "This is the body of the post", 122)
        postRequest.enqueue(object : Callback<RetrofitResponse>{
            override fun onResponse(
                call: Call<RetrofitResponse>,
                response: Response<RetrofitResponse>
            ) {
                val responseData = response.body()
                 Log.d("MainActivity ID",responseData?.id.toString())
                 Log.d("MainActivity Title",responseData?.title.toString())
                 Log.d("MainActivity Body",responseData?.body.toString())
                 Log.d("MainActivity UserID",responseData?.userId.toString())
            }

            override fun onFailure(call: Call<RetrofitResponse>, t: Throwable) {
                Log.e("MainActivity", t.message.toString())
            }

        } )*/

        val patchRequest = RetrofitService.retrofitInstance.patchData(10, "This is a new title ")
        patchRequest.enqueue(object : Callback<RetrofitResponse>{
            override fun onResponse(
                call: Call<RetrofitResponse>,
                response: Response<RetrofitResponse>
            ) {
                val responseData = response.body()
                Log.d("MainActivity ID",responseData?.id.toString())
                Log.d("MainActivity Title",responseData?.title.toString())
                Log.d("MainActivity Body",responseData?.body.toString())
                Log.d("MainActivity UserID",responseData?.userId.toString())
            }

            override fun onFailure(call: Call<RetrofitResponse>, t: Throwable) {
                Log.e("MainActivity", t.message.toString())
            }

        })


    }
}