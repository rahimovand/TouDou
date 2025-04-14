package com.example.toudou.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toudou.model.todo
import com.example.toudou.ui.theme.TouDouTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TodoItemRep(
    modifier: Modifier = Modifier,
    todo: todo,
    shape: Shape = RoundedCornerShape(16.dp),
    itemClicked: () -> Unit, // normal click
    itemLongClicked: () -> Unit, // long click to item
    itemEditClicked: () -> Unit, // item edit button clicked
    isItemCheckClicked: () -> Unit // item checked clicked up
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape)
            .combinedClickable(
                onClick = itemClicked,
                onLongClick = itemLongClicked
            )
        ,
        shape = shape,

        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(95.dp)
                .padding(10.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(todo.name, maxLines = 1, style = MaterialTheme.typography.titleLarge)
                Text(todo.description, maxLines = 1, style = MaterialTheme.typography.labelMedium)
            }
            VerticalDivider(
                modifier = modifier.padding(start = 5.dp, end = 10.dp),
                thickness = 0.5.dp,
                color = MaterialTheme.colorScheme.inverseSurface
            )
            IconButton(
                onClick = itemEditClicked
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
            IconButton(
                onClick = isItemCheckClicked
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null)
            }
        }
    }

}