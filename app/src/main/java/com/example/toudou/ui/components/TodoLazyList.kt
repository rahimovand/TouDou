package com.example.toudou.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.toudou.model.todo


@Composable
fun TodoListItems(
    modifier: Modifier = Modifier,
    list: List<todo>,
    itemToDelete: (todo) -> Unit,
    itemNormalClick: (Int) -> Unit,
    itemCheckClicked: (todo) -> Unit,
    itemEditClicked: (Int) -> Unit
) {
    val oddShape = CutCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
    val evenShape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 80.dp, start = 10.dp, end = 10.dp, top = 10.dp),
    ) {
        items(list.size, key = { it }) {
            TodoItemRep(
                shape = if (it % 2 != 0) oddShape else evenShape,
                itemClicked = {
                    itemNormalClick(it)
                },
                isItemCheckClicked = { itemCheckClicked(list[it]) },
                itemEditClicked = {
                    itemEditClicked(list[it].id)
                },
                itemLongClicked = { itemToDelete(list[it]) },
                todo = list[it]
            )
        }

    }
}