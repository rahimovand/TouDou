package com.example.toudou.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.toudou.model.todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert
    suspend fun insertTodo(todo: todo)

    @Delete
    suspend fun deleteTodo(todo: todo)

    @Query("select * from todo_table order by id asc")
    suspend fun getAllTodo(): List<todo>

    @Query("select * from todo_table where id = :id")
    suspend fun getTodoFromId(id: Int): todo

}