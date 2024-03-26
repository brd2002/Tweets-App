package com.example.tweetsapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsapp.repos.TweetsRepo
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repo: TweetsRepo) : ViewModel() {
    val categories : StateFlow<List<String>>
        get() = repo.categories
    init {
        viewModelScope.launch {
            repo.getCategories()
        }
    }
}