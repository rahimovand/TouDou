package com.example.toudou.viewModel

import android.app.Application
import androidx.compose.runtime.State
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toudou.model.todo
import com.example.toudou.repository.TodoRepository
import com.example.toudou.room.TodoDataBase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TodoViewModel(application: Application) : AndroidViewModel(application) {


    private val db = TodoDataBase.getDatabase(application)
    private val repository = TodoRepository(db.todoDao())

    private val _task = MutableStateFlow<List<todo>>(emptyList())
    val task: StateFlow<List<todo>> = _task

    init {
        viewModelScope.launch {
            _task.value = repository.getAllTodo()
        }
    }

    fun insertTodo(todo: todo) {
        viewModelScope.launch {
            repository.insertTodo(todo)
            _task.value = repository.getAllTodo()
        }
    }

    fun updateTodo(todo: todo){
        viewModelScope.launch {
            repository.updateTodo(todo)
            _task.value = repository.getAllTodo()
        }
    }

    fun deleteTodo(todo: todo) {
        viewModelScope.launch {
            repository.deleteTodo(todo)
            _task.value = repository.getAllTodo()
        }
    }

    fun getTodoById(id: Int): todo? = runBlocking {
        repository.getTodoFromId(id)
    }
}