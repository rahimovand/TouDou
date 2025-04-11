package com.example.toudou.ui.components

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toudou.model.todo


@Composable
fun TodoListItems(
    modifier: Modifier = Modifier,
    list: List<todo>,
    itemToDelete: (todo) -> Unit
) {
    val oddShape = CutCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
    val evenShape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
    var isEachItemClicked by remember { mutableStateOf(false) }
    var isItemLongClicked by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 80.dp, start = 10.dp, end = 10.dp, top = 10.dp),
    ) {
        items(list.size, key = { it }) {
            TodoItemRep(
                shape = if (it % 2 != 0) oddShape else evenShape,
                itemClicked = { isEachItemClicked = !isEachItemClicked },
                isItemCheckClicked = {},
                itemEditClicked = {},
                itemLongClicked = { isItemLongClicked = true }
            )
        }

    }
}