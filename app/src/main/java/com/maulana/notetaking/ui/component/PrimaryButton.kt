package com.maulana.notetaking.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maulana.notetaking.HomeRoute

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit){
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth().height(74.dp), shape = RoundedCornerShape(12.dp)){
        Text(text = text)
    }
}