package com.example.toudou.ui.components

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toudou.model.todo

@Composable
fun TodoListItems(
    modifier: Modifier = Modifier
) {

    val list = listOf(
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = ""),
        todo(name = "", description = "", data = "")


    )

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 80.dp, start = 10.dp, end = 10.dp),
    ) {
        itemsIndexed(list) { index, item ->
            TodoItemRep(

            )
        }
    }
}
