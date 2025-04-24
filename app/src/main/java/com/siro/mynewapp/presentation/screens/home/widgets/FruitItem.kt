package com.siro.mynewapp.presentation.screens.home.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.siro.mynewapp.data.models.Fruit

@Composable
fun FruitItem(
    fruit: Fruit,
    onClicked: (Fruit) -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClicked(fruit) }
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = fruit.title,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = fruit.description,
                fontSize = 25.sp,
            )
        }
    }
}