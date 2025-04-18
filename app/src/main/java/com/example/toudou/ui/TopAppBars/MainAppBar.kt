package com.example.toudou.ui.TopAppBars

import android.app.Activity
import android.app.Application
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.toudou.logic.TaskViewModelFactory
import com.example.toudou.room.TodoDataBase
import com.example.toudou.viewModel.TodoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppbar(
    modifier: Modifier = Modifier,
    activity: Activity? = LocalActivity.current
) {


    var isExpandedForTopAppBarMenu by rememberSaveable { mutableStateOf(false) }

    TopAppBar(

        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Tou - Dou",
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = modifier.weight(1f))
                IconButton(
                    modifier = modifier.padding(end = 5.dp),
                    onClick = { isExpandedForTopAppBarMenu = !isExpandedForTopAppBarMenu }
                ) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }

            }
        },
        actions = {

            DropdownMenu(
                expanded = isExpandedForTopAppBarMenu,
                onDismissRequest = { isExpandedForTopAppBarMenu = false },
                offset = DpOffset(x = (-15).dp, y = 25.dp),
                modifier = modifier,
                properties = PopupProperties(focusable = true)
            ) {
                DropdownMenuItem(
                    text = {
                        Text(
                            "Exit",
                            textAlign = TextAlign.Center,
                            modifier = modifier.fillMaxWidth()
                        )
                    },
                    onClick = {
                        activity?.finish()
                    }
                )

            }

        }
    )
}