package com.miracle.memorial.presentation.feature.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miracle.memorial.presentation.core.theme.MemorialTheme
import com.miracle.memorial.presentation.feature.start.StartScreen

@Composable
fun LoginScreen(navController: NavController) {
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    val navController = rememberNavController()

    MemorialTheme() {
        StartScreen(navController = navController)
    }
}