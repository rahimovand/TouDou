package com.example.toudou.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.toudou.screens.AddScreen
import com.example.toudou.screens.MainScreen
import com.example.toudou.destinations.Screens
import com.example.toudou.ui.theme.TouDouTheme
import com.example.toudou.viewModel.TodoViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val TodoViewModel:TodoViewModel = viewModel()

    TouDouTheme {
        NavHost(navController = navController, startDestination = Screens.MainScreen.name) {
            composable(Screens.MainScreen.name) {
                MainScreen(navController = navController, TodoViewModel = TodoViewModel)
            }
            composable(Screens.AddScreen.name) {
                AddScreen(navController = navController)
            }
        }
    }
}