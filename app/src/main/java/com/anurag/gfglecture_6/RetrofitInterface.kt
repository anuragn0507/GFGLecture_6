package com.anurag.gfglecture_6

import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {

    @FormUrlEncoded
    @POST("posts")
    fun postData(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: Int
    ): Call<RetrofitResponse>

    @POST("posts")
    fun postBody(@Body retrofitRequest: RetrofitRequest): Call<RetrofitResponse>

    // URL for post request -> https://jsonplaceholder.typicode.com/posts

    @FormUrlEncoded
    @POST("posts/{id}")
    fun patchData(@Path("id") id: Int,
                  @Field("title") title: String
    ): Call<RetrofitResponse>

}