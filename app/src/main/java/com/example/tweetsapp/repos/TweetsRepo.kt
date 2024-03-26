package com.example.tweetsapp.repos

import com.example.tweetsapp.api.TweetsApi
import com.example.tweetsapp.models.TweetlistItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepo @Inject constructor(private val tweetsApi: TweetsApi) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories :StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetlistItem>>(emptyList())
    val tweets :StateFlow<List<TweetlistItem>>
        get() = _tweets

    suspend fun getCategories(){
        var respose = tweetsApi.getCategories()
        if (respose.isSuccessful && respose.body()!= null){
                _categories.emit(respose.body()!!)
        }
    }
    suspend fun getTweets(category: String){
        var respose = tweetsApi.getTweets(category)
        if (respose.isSuccessful && respose.body()!= null){
            _tweets.emit(respose.body()!!)
        }
    }
}