package com.example.toudou.ui.components

import androidx.compose.runtime.Composable
import com.example.toudou.navigation.AppNavigation
import com.example.toudou.ui.theme.TouDouTheme

@Composable
fun MyApp(){
    TouDouTheme {
        AppNavigation()
    }
}