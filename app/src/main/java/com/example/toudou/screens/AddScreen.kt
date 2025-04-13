package com.example.toudou.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.toudou.ui.theme.TouDouTheme
import com.example.toudou.viewModel.TodoViewModel

@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    TodoViewModel:TodoViewModel = viewModel()
) {
    Column(
        modifier = modifier.fillMaxSize().padding(2.dp)
    ) {

    }
}

@Preview
@Composable
fun AddScreenPreview() {
    TouDouTheme {
        AddScreen(navController = rememberNavController())
    }
}
@Preview
@Composable
fun AddScreenPreviewDArk() {
    TouDouTheme(darkTheme = true) {
        AddScreen(navController = rememberNavController())
    }
}