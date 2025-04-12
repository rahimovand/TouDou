package com.example.toudou.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DeleteItemDialog(
    areYouSureToDelete: () -> Unit,
    dissMissDialog: () -> Unit
) {
    AlertDialog(
        title = { Text("Delete") },
        text = { Text("Are you sure you want to delete this item?") },
        onDismissRequest = dissMissDialog,
        confirmButton = {
            Button(
                onClick = areYouSureToDelete
            ) {
                Text("Sure")
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = dissMissDialog
            ) {
                Text("Cancel")
            }
        }
    )
}