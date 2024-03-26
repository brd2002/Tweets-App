package com.example.tweetsapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsapp.viewModels.DetailsViewModel

@Composable
fun DetailScreen() {
    val detailViewModel : DetailsViewModel  = viewModel()
    val tweets = detailViewModel.tweets.collectAsState()
    LazyColumn {
        items(tweets.value){
            TweetListItem(tweet = it.text)
        }
    }
}
@Composable
fun TweetListItem(tweet:String) {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp) ,
        border = BorderStroke(1.dp , Color.Black) ,
        content = {
            Text(text = tweet ,
                modifier = Modifier.padding(16.dp) , style = MaterialTheme.typography.bodyMedium)
        }
    )
}