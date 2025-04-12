package com.example.toudou.Screens


import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.toudou.model.todo
import com.example.toudou.ui.components.MyTopAppBar
import com.example.toudou.ui.components.TodoAddButton
import com.example.toudou.ui.components.TodoListItems
import com.example.toudou.ui.theme.TouDouTheme
import com.example.toudou.viewModel.TodoViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    taskViewModel:TodoViewModel = viewModel()
) {

    val task by taskViewModel.task.collectAsState()
    var areYouSureToDelete by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            TodoAddButton(
                onClick = {
                    // add button clicked
                }
            )
        },
        topBar = { MyTopAppBar() }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {
            TodoListItems(
                list = task,
                itemToDelete = {
                  areYouSureToDelete = true
                },
                itemNormalClick = {
                    // item normal click
                }
            )
            if (areYouSureToDelete) {
                AlertDialog(
                    onDismissRequest = { areYouSureToDelete = false },
                    confirmButton = { taskViewModel.removeTask() }
                )
            }
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