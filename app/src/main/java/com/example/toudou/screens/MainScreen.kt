package com.example.toudou.screens


import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.toudou.model.todo
import com.example.toudou.ui.components.DeleteItemDialog
import com.example.toudou.ui.components.EditEachItem
import com.example.toudou.ui.components.TodoListItems
import com.example.toudou.viewModel.TodoViewModel


@Composable
fun MainScreen(

    navController: NavController, // not used currenly but in the future might probably
    TodoViewModel: TodoViewModel,
    context: Context = LocalContext.current
) {


    val task by TodoViewModel.task.collectAsState()
    var todo by rememberSaveable { mutableStateOf<todo?>(null) }  // this will be non-null when item to delete is clicked
    var idForEditItem by rememberSaveable { mutableStateOf<Int?>(null) }


    TodoListItems(
        list = task,
        itemToDelete = {
            todo = it
        },
        itemNormalClick = {
            Toast.makeText(context, "${it + 1}-st Item Clicked", Toast.LENGTH_SHORT).show()
        },
        itemCheckClicked = {
            Toast.makeText(context, "Congratulations !", Toast.LENGTH_SHORT).show()
            TodoViewModel.deleteTodo(it)
        },
        itemEditClicked = {
            idForEditItem = it
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
    } // this code is for deleting like are you really sure
    if (idForEditItem != null) {
        val gotTodo: todo = TodoViewModel.getTodoById(idForEditItem!!)!!
        EditEachItem(
            todo = gotTodo,
            onDissMiss = { idForEditItem = null },
            infoToChange = {
                TodoViewModel.updateTodo(it)
                idForEditItem = null
            }
        )
    }
}
