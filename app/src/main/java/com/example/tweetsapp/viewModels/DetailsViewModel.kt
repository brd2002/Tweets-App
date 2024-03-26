package com.example.tweetsapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsapp.models.TweetlistItem
import com.example.tweetsapp.repos.TweetsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repo: TweetsRepo) : ViewModel() {
    val tweets : StateFlow<List<TweetlistItem>>
        get() = repo.tweets
    init {
        viewModelScope.launch {
            repo.getTweets("android")
        }
    }
}