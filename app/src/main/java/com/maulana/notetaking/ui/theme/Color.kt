package com.maulana.notetaking.ui.theme

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Beige = Color(0xFFF8EEE2)
val TerraCotta = Color(0xFFD9614C)
val Lotion = Color(0xFFFFFDFA)

@Composable
fun DefaultTextFieldColor() = TextFieldDefaults.colors(
    focusedContainerColor = Color.White,
    disabledContainerColor = Color.White,
    unfocusedContainerColor = Color.White,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent
)