package com.example.toudou.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.toudou.logic.checkOneString
import com.example.toudou.logic.twoStringsChecker
import com.example.toudou.model.todo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditEachItem(
    todo: todo,
    modifier: Modifier = Modifier,
    onDissMiss: () -> Unit,
    infoToChange: (todo) -> Unit
) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var name by rememberSaveable { mutableStateOf(todo.name) }
    var desc by rememberSaveable { mutableStateOf(todo.description) }


    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDissMiss
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .imePadding()
                .padding(top = 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("New Name:")
            HorizontalDivider(modifier = modifier.padding(10.dp))
            OutlinedTextField(
                modifier = modifier.fillMaxWidth().padding(15.dp),
                value = name,
                onValueChange = { name = it },
                trailingIcon = {
                    if (checkOneString(name)){
                        IconButton(
                            onClick = {
                                name = ""
                            }
                        ) {
                            Icon(imageVector = Icons.Default.Clear,contentDescription = null)
                        }
                    }
                }
            )
            Spacer(modifier = modifier.height(10.dp))
            Text("New Description:")
            HorizontalDivider(modifier = modifier.padding(10.dp))

            OutlinedTextField(
                modifier = modifier.fillMaxWidth().padding(15.dp),
                value = desc,
                onValueChange = { desc = it },
                trailingIcon = {
                    if (checkOneString(desc)){
                        IconButton(
                            onClick = {
                                desc = ""
                            }
                        ) {
                            Icon(imageVector = Icons.Default.Clear,contentDescription = null)
                        }
                    }
                }
            )
            Spacer(modifier = modifier.height(20.dp))
            Row {
                Spacer(modifier = modifier.weight(1f))
                Button(
                    onClick = onDissMiss
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = modifier.width(10.dp))
                OutlinedButton(
                    onClick = {
                        infoToChange(todo.copy(name = name, description = desc))
                    },
                    enabled = twoStringsChecker(name,desc)
                ) {
                    Text("Save")
                }
                Spacer(modifier = modifier.width(40.dp))
            }
            Spacer(modifier = modifier.height(40.dp))
        }
    }
}