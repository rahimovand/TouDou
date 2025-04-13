package com.example.toudou.ui.TopAppBars

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.toudou.destinations.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    TopAppBar(
        title = {},
        actions = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
            Spacer(modifier = modifier.weight(1f))
        }
    )
}

