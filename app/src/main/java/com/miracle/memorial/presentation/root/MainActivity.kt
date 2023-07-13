package com.miracle.memorial.presentation.root

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.miracle.memorial.presentation.core.component.MyTopBar
import com.miracle.memorial.presentation.core.component.bottomnavigation.BottomNavBar
import com.miracle.memorial.presentation.core.component.bottomnavigation.BottomNavGraph
import com.miracle.memorial.presentation.core.theme.MemorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemorialTheme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { MyTopBar() },
        bottomBar = { BottomNavBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController)
    }

}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MemorialTheme() {
        MainScreen()
    }
}