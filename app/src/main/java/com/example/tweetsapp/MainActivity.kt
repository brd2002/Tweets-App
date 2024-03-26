package com.example.tweetsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TweetsAppTheme {
                // A surface container using the 'background' color from the theme
             Scaffold(
                 topBar = {
                     TopAppBar(title = {
                         Text(text = "TweetWave" , color = Color.White)
                     }  ,
                         colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black))
                 }
             ) {
                Box (modifier = Modifier.padding(it)){
                    App()
                }

             }
            }
        }
    }
}

@Composable
fun App() {
    val navControler = rememberNavController()
    NavHost(navController = navControler, startDestination = "category") {
        composable(route = "category"){
            CategoryScreen {
                navControler.navigate("detail/$it")
            }
        }
        composable(route = "detail/{category}" , arguments =
        listOf(
            navArgument("category"){
                type = NavType.StringType
            }
        )
        ){
            DetailScreen()
        }
    }
}