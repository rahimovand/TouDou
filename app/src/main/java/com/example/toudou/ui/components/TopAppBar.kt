package com.example.toudou.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    shape: Shape = CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
) {

    var isExpandedForTopAppBarMenu by rememberSaveable { mutableStateOf(true) }

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Tou - Dou",
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = modifier.weight(1f))
                IconButton(
                    modifier = modifier.padding(10.dp),
                    onClick = { isExpandedForTopAppBarMenu = !isExpandedForTopAppBarMenu }
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }
        },
        actions = {

            DropdownMenu(
                expanded = isExpandedForTopAppBarMenu,
                onDismissRequest = { isExpandedForTopAppBarMenu = false },
                offset = DpOffset(x = -15.dp, y = 25.dp),
                modifier = modifier
                    .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
            ) {

                DropdownMenuItem(
                    text = {
                        Text(
                            "Clear All",
                            textAlign = TextAlign.Center,
                            modifier = modifier.fillMaxWidth()
                        )
                    },
                    onClick = {
                        // clicked
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            "Exit",
                            textAlign = TextAlign.Center,
                            modifier = modifier.fillMaxWidth(0.7f)
                        )
                    },
                    onClick = {
                        // clicked
                    }
                )

            }
        }
    )
}