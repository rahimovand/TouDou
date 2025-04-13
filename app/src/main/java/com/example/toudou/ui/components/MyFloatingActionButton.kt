package com.example.toudou.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MyFloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    shape: Shape = RoundedCornerShape(16.dp)
) {

    FloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
    ) {
        Icon(imageVector = icon, contentDescription = null)
    }
}