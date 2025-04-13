package com.example.toudou.screens


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.toudou.model.todo
import com.example.toudou.ui.components.DeleteItemDialog
import com.example.toudou.ui.components.TodoListItems
import com.example.toudou.viewModel.TodoViewModel

@Composable
fun MainScreen(
    navController: NavController,
    TodoViewModel: TodoViewModel = viewModel()
) {

    val task by TodoViewModel.task.collectAsState()
    var todo by rememberSaveable { mutableStateOf<todo?>(null) }

    TodoListItems(
        list = task,
        itemToDelete = {
            todo = it
        },
        itemNormalClick = {
            // item normal clicked here some kind of thing would happen
        }
    )
    if (todo != null) {
        DeleteItemDialog(
            areYouSureToDelete = {
                TodoViewModel.removeTask(todo!!)
                todo = null
            },
            dissMissDialog = {
                todo = null
            }
        )
    }
}
