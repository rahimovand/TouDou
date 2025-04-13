package com.example.toudou.ui.TopAppBars

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    TopAppBar(
        title = {

        },
        actions = {

            IconButton(
                modifier = modifier.padding(start = 5.dp),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
            Text("Add TouDou",
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = modifier.weight(1f))
        }
    )
}

