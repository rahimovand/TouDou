package com.example.toudou.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.toudou.destinations.Screens
import com.example.toudou.model.todo
import com.example.toudou.ui.components.DeleteItemDialog
import com.example.toudou.ui.components.MyTopAppBar
import com.example.toudou.ui.components.TodoAddButton
import com.example.toudou.ui.components.TodoListItems
import com.example.toudou.viewModel.TodoViewModel

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    TodoViewModel: TodoViewModel = viewModel()
) {

    val task by TodoViewModel.task.collectAsState()
    var areYouSureToDelete by rememberSaveable { mutableStateOf(false) }
    var todo by rememberSaveable { mutableStateOf<todo?>(null) }

    Scaffold(
        floatingActionButton = {
            TodoAddButton(
                onClick = {
                   navController.navigate(Screens.AddScreen.name)
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
                    todo = it
                },
                itemNormalClick = {
                    // item normal clicked here some kind of thing would happen
                }
            )
            if (areYouSureToDelete && todo != null) {
                DeleteItemDialog(
                    areYouSureToDelete = {
                        TodoViewModel.removeTask(todo!!)
                        areYouSureToDelete = false // clearing up
                    },
                    dissMissDialog = {
                        todo = null
                        areYouSureToDelete = false // clearing up
                    }
                )
            }
        }
    }
}