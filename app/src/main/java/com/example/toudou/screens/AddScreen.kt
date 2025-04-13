package com.example.toudou.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.toudou.ui.theme.TouDouTheme
import com.example.toudou.viewModel.TodoViewModel

@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    TodoViewModel: TodoViewModel = viewModel()
) {

    val task by TodoViewModel.task.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(2.dp)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {

        Box(contentAlignment = Alignment.BottomEnd) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f),
                shape = CutCornerShape(topStart = 70.dp, bottomEnd = 210.dp)
            ) {

                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .weight(1f)
                        .padding(top = 50.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Name",
                        modifier = modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Monospace
                    )
                    VerticalDivider(
                        modifier = modifier
                            .height(20.dp)
                            .padding(top = 4.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                    Surface(
                        modifier = modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.12f)
                            .padding(2.dp),
                        shape = RoundedCornerShape(topStart = 40.dp, bottomEnd = 40.dp)
                    ) {
                        Column(
                            modifier = modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            OutlinedTextField(
                                modifier = modifier
                                    .fillMaxSize()
                                    .padding(2.dp),
                                value = "asdasdasd",
                                onValueChange = {},
                                maxLines = 1,
                                shape = RoundedCornerShape(topStart = 40.dp, bottomEnd = 40.dp)
                            )

                        }
                    }

                    Text(
                        text = "Description",
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Monospace
                    )
                    VerticalDivider(
                        modifier = modifier
                            .height(20.dp)
                            .padding(top = 4.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                    Surface(
                        modifier = modifier
                            .padding(2.dp)
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.5f),
                        shape = RoundedCornerShape(bottomEnd = 25.dp, topStart = 25.dp)
                    ) {
                        Column {
                            OutlinedTextField(
                                modifier = modifier
                                    .fillMaxSize()
                                    .padding(2.dp),
                                value = "Description",
                                onValueChange = {},
                                shape = RoundedCornerShape(bottomEnd = 25.dp, topStart = 25.dp)
                            )
                        }
                    }
                }
            }
            FloatingActionButton(
                modifier = modifier
                    .padding(end = 20.dp, bottom = 20.dp)
                    .clip(RoundedCornerShape(16.dp)),
                onClick = {
                    navController.popBackStack()
                },
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null)
            }

        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3A)
@Composable
fun AddScreenPreview() {
    TouDouTheme {
        AddScreen(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreviewDArk() {
    TouDouTheme(darkTheme = true) {
        AddScreen(navController = rememberNavController())
    }
}