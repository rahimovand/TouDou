package com.example.toudou.screens

import android.content.Context
import android.widget.Toast
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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.toudou.logic.checkOneString
import com.example.toudou.logic.twoStringsChecker
import com.example.toudou.model.todo
import com.example.toudou.ui.components.MyFloatingActionButton
import com.example.toudou.ui.theme.TouDouTheme
import com.example.toudou.viewModel.TodoViewModel

@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    TodoViewModel: TodoViewModel,
    context: Context = LocalContext.current
) {


    var name by rememberSaveable { mutableStateOf("") }
    var desc by rememberSaveable { mutableStateOf("") }

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
                    .fillMaxHeight(1f)
                    .padding(start = 5.dp, end = 5.dp),
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
                        fontFamily = FontFamily.Serif,
                        style = MaterialTheme.typography.titleLarge
                    )
                    VerticalDivider(
                        modifier = modifier
                            .height(20.dp)
                            .padding(top = 4.dp),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.secondary
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
                                    .padding(2.dp)
                                    .align(Alignment.CenterHorizontally),
                                value = name,
                                onValueChange = { name = it },
                                maxLines = 1,
                                shape = RoundedCornerShape(topStart = 40.dp, bottomEnd = 40.dp),
                                trailingIcon = {
                                    if (checkOneString(name)) {
                                        IconButton(
                                            modifier = modifier.padding(end = 15.dp),
                                            onClick = {
                                                name = " "
                                            }
                                        ) {
                                            Icon(Icons.Default.Clear, contentDescription = null)
                                        }
                                    }
                                },

                                )

                        }
                    }

                    Text(
                        text = "Description",
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        style = MaterialTheme.typography.titleLarge
                    )
                    VerticalDivider(
                        modifier = modifier
                            .height(20.dp)
                            .padding(top = 4.dp),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.secondary
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
                                value = desc,
                                enabled = checkOneString(name),
                                onValueChange = { desc = it },
                                shape = RoundedCornerShape(bottomEnd = 25.dp, topStart = 25.dp)
                            )
                        }
                    }
                }
            }
            MyFloatingActionButton(
                modifier = modifier.padding(end = 20.dp, bottom = 20.dp),
                onClick = {
                    if (twoStringsChecker(name, desc)) {

                        val todo = todo(name = name, description = desc)
                        TodoViewModel.insertTodo(todo)
                        navController.popBackStack()

                    } else {
                        Toast.makeText(context, "Blank Area Found", Toast.LENGTH_SHORT).show()
                    }
                },
                icon = Icons.Default.Check
            )

        }
    }
}