package com.example.tweetsy.Api

import com.example.tweetsy.model.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/6688e3d6ad19ca34f88391c1?meta=false")
     suspend fun getTweets(@Header("X-JSON-Path")category:String):Response<List<TweetListItem>>

     @GET("/v3/b/6688e3d6ad19ca34f88391c1?meta=false")
     @Headers("X-JSON-Path:tweets..category")
     suspend fun getCategories():Response<List<String>>
}