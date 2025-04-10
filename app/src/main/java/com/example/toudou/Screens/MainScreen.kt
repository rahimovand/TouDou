package com.example.toudou.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toudou.ui.components.MyTopAppBar
import com.example.toudou.ui.components.TodoAddButton
import com.example.toudou.ui.components.TodoListItems
import com.example.toudou.ui.theme.TouDouTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {


    Scaffold(
        floatingActionButton = {
            TodoAddButton(
                onClick = {
                    // add button clicked
                }
            )
        },
        topBar = {
            MyTopAppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {

            TodoListItems()
        }
    }
}


@Preview
@Composable
fun LightTheme() {
    TouDouTheme(darkTheme = false) {
        MainScreen()
    }
}

@Preview
@Composable
fun DarkTheme() {
    TouDouTheme(darkTheme = true) {
        MainScreen()
    }
}