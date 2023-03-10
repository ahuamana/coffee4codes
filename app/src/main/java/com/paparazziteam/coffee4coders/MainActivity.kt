package com.paparazziteam.coffee4coders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paparazziteam.coffee4coders.ui.screens.DetailScreen
import com.paparazziteam.coffee4coders.ui.screens.FeedScreen
import com.paparazziteam.coffee4coders.ui.theme.Coffee4CodersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           NavigationHost()
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    Coffee4CodersTheme() {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed") {
                composable(route = "feed") {
                    FeedScreen(navController = navController)
                }
                composable(route = "detail") {
                    DetailScreen()
                }
            }
        }
    }
}



