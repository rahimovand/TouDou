package com.example.toudou.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.toudou.destinations.Screens
import com.example.toudou.screens.AddScreen
import com.example.toudou.screens.MainScreen
import com.example.toudou.ui.TopAppBars.AddAppBar
import com.example.toudou.ui.TopAppBars.MainAppbar
import com.example.toudou.ui.components.TodoAddButton
import com.example.toudou.viewModel.TodoViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val TodoViewModel: TodoViewModel = viewModel()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        floatingActionButton = {
            TodoAddButton(
                onClick = {
                    navController.navigate(Screens.AddScreen.name)
                }
            )
        },
        topBar = {
            when (currentRoute) {
                Screens.MainScreen.name -> MainAppbar()
                Screens.AddScreen.name -> AddAppBar(navController = navController)
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Screens.MainScreen.name,
            modifier = modifier.padding(paddingValues)
        ) {
            composable(Screens.MainScreen.name) {
                MainScreen(
                    navController = navController,
                    TodoViewModel = TodoViewModel
                )
            }
            composable(Screens.AddScreen.name) {
                AddScreen(
                    navController = navController, TodoViewModel = TodoViewModel
                )
            }
        }

    }
}
