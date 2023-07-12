package com.miracle.memorial.presentation.feature.start

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.miracle.memorial.presentation.core.component.bottomnavigation.BottomNavItem
import com.miracle.memorial.presentation.feature.CommScreen
import com.miracle.memorial.presentation.feature.Home.HomeScreen
import com.miracle.memorial.presentation.feature.ProfileScreen
import com.miracle.memorial.presentation.feature.login.LoginScreen
import com.miracle.memorial.presentation.feature.signup.SignupFirstScreen
import com.miracle.memorial.presentation.feature.signup.SignupSecondScreen
import com.miracle.memorial.presentation.feature.signup.SignupThirdScreen
import com.miracle.memorial.presentation.root.MainScreen

@ExperimentalMaterial3Api
@Composable
fun StartNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = StartNavItem.start) {
        composable(StartNavItem.start) {
            StartScreen(navController)
        }
        composable(StartNavItem.signup_first) {
            SignupFirstScreen(navController)
        }
        composable(StartNavItem.signup_second) {
            SignupSecondScreen(navController)
        }
        composable(StartNavItem.signup_third) {
            SignupThirdScreen(navController)
        }
        composable(StartNavItem.login) {
            LoginScreen(navController)
        }
        composable(StartNavItem.main) {
            MainScreen()
        }
    }

}