package com.example.tweetsy.repository

import com.example.tweetsy.Api.TweetsyAPI
import com.example.tweetsy.model.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private  val tweetsyAPI: TweetsyAPI) {


    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>
        get() = _categories
    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets : StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getCategories(){
        val responce = tweetsyAPI.getCategories()
        if (responce.isSuccessful && responce.body()!=null){
            _categories.emit(responce.body()!!)
        }
    }
    suspend fun getTweets(category: String){
        val responce = tweetsyAPI.getTweets("tweets[?(@.category==\"$category\")]")
        if (responce.isSuccessful && responce.body()!=null){
            _tweets.emit(responce.body()!!)
        }
    }

}