package com.example.toudou.viewModel

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.example.toudou.model.todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TodoViewModel : ViewModel() {

    private val _task = MutableStateFlow<List<todo>>(listOf(todo(name = "Odiljdasadsdasdasdasdasd", description = "sadfffffffffffdsssssssssssssdffdsfdssdfdsfdfdfssdfds", data = "dffsdfsdfsdfsdfsdfsdfsdfsdfsdf")))
    val task: StateFlow<List<todo>> = _task

    fun addTask(todo: todo) {
        _task.value += todo
    }

    fun removeTask(todo: todo) {
        _task.value -= todo
    }


}