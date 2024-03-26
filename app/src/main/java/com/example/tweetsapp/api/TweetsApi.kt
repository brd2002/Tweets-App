package com.example.tweetsapp.api

import com.example.tweetsapp.models.TweetlistItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface TweetsApi {
    @GET("/v3/b/6601cd792b1b334a633b3bc1?meta=false")

   suspend fun getTweets (@Header("X-JSON-Path") category : String) :Response<List<TweetlistItem>>
   @GET("/v3/b/6601cd792b1b334a633b3bc1?meta=false")
   @Headers("X-JSON-Path: \$..category")
   suspend fun getCategories() : Response<List<String>>
}