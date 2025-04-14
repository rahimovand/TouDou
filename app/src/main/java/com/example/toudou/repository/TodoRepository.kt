package com.example.toudou.repository

import com.example.toudou.model.todo
import com.example.toudou.room.TodoDao

class TodoRepository(private val todoDao: TodoDao) {

    suspend fun insertTodo(todo: todo) {
        todoDao.insertTodo(todo)
    }

    suspend fun deleteTodo(todo: todo) {
        todoDao.deleteTodo(todo)
    }

    suspend fun getAllTodo(): List<todo> {
        return todoDao.getAllTodo()
    }

    suspend fun getTodoFromId(id: Int): todo {
        return todoDao.getTodoFromId(id)
    }

}