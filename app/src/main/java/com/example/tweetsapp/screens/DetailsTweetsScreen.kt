package com.example.tweetsapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsapp.viewModels.DetailsViewModel

@Composable
fun DetailScreen() {
    val detailViewModel : DetailsViewModel  = hiltViewModel()
    val tweets = detailViewModel.tweets.collectAsState()
    if(tweets.value.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )

        }
    }else {
        LazyColumn {
            items(tweets.value){
                TweetListItem(tweet = it.text)
            }
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