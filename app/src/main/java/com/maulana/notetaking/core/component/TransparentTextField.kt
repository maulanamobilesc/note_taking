package com.maulana.notetaking.core.component

import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.maulana.notetaking.ui.theme.TerraCotta

@Composable
fun TransparentTextField(
    modifier: Modifier,
    value: String,
    placeholder: @Composable (() -> Unit)?,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,  // Transparent when focused
            unfocusedContainerColor = Color.Transparent, // Transparent when unfocused
            disabledContainerColor = Color.Transparent,  // Transparent when disabled
            errorContainerColor = Color.Transparent,     // Transparent when in error state
            focusedTextColor = Color.Black,              // Text color when focused
            unfocusedTextColor = Color.Black,            // Text color when unfocused
            disabledTextColor = Color.Gray,              // Text color when disabled
            errorTextColor = Color.Red,                  // Text color when in error state
            focusedIndicatorColor = TerraCotta,          // Indicator color when focused
            unfocusedIndicatorColor = Color.Gray         // Indicator color when unfocused
        ), placeholder = placeholder
    )
}