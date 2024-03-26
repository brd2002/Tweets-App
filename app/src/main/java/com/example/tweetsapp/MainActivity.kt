package com.example.tweetsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tweetsapp.api.TweetsApi
import com.example.tweetsapp.screens.CategoryScreen
import com.example.tweetsapp.screens.DetailScreen
import com.example.tweetsapp.ui.theme.TweetsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var tweetsApi: TweetsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TweetsAppTheme {
                // A surface container using the 'background' color from the theme
//                CategoryScreen()
                DetailScreen()
            }
        }
    }
}

