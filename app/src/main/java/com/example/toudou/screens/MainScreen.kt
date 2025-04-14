package com.example.toudou.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FloatingActionButton
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
    navController: NavController, // not used currenly but in the future might probably
    TodoViewModel: TodoViewModel
) {

    val task by TodoViewModel.task.collectAsState()
    var todo by rememberSaveable { mutableStateOf<todo?>(null) }

    TodoListItems(
        list = task,
        itemToDelete = {
            todo = it
        },
        itemNormalClick = {
            // item normal clicked here some AlertDialog or smth opens up and info just will be shown
        }
    )
    if (todo != null) {
        DeleteItemDialog(
            areYouSureToDelete = {
                TodoViewModel.deleteTodo(todo!!)
                todo = null
            },
            dissMissDialog = {
                todo = null
            }
        )
    }
}
