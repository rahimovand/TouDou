package com.example.toudou.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.toudou.model.todo


@Database(
    entities = [todo::class],
    exportSchema = false,
    version = 1
)
abstract class TodoDataBase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDataBase? = null

        fun getDatabase(context: Context): TodoDataBase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDataBase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}