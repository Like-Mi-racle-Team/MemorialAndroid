package com.miracle.memorial.presentation.core.component.bottomnavigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.miracle.memorial.presentation.core.component.bottomnavigation.BottomNavItem
import com.miracle.memorial.presentation.feature.CommScreen
import com.miracle.memorial.presentation.feature.Home.HomeScreen
import com.miracle.memorial.presentation.feature.ProfileScreen

@ExperimentalMaterial3Api
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(
            route = BottomNavItem.Home.route,
        ) {
            HomeScreen()
        }
        composable(
            route = BottomNavItem.Comm.route,
        ) {
            CommScreen()
        }
        composable(
            route = BottomNavItem.Profile.route,
        ) {
            ProfileScreen()
        }

    }

}