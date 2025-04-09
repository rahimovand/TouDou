package com.example.toudou.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    modifier: Modifier =Modifier
) {
    TopAppBar(
        title = {
            Row {
                Text(
                    text = "Tou - Dou",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    )
}