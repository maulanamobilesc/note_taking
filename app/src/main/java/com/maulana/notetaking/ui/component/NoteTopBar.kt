package com.maulana.notetaking.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maulana.notetaking.ui.theme.GlobalDimension
import com.maulana.notetaking.ui.theme.NoteTakingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NoteTopBar(scope: CoroutineScope, drawerState: DrawerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = GlobalDimension.secondaryPadding,
                end = GlobalDimension.secondaryPadding,
                top = GlobalDimension.mainPadding
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {
            scope.launch {
                drawerState.apply {
                    if (isClosed) open() else close()
                }
            }
        }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        }
        Text(text = "All Notes")
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        }
    }
}

@Composable
fun InputNoteTopBar(onClickLeftAction: () -> Unit, onClickRightAction: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = GlobalDimension.secondaryPadding,
                end = GlobalDimension.secondaryPadding,
                top = GlobalDimension.mainPadding
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onClickLeftAction) {
            Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Menu")
        }
        Text(text = "All Notes")
        IconButton(onClick = onClickRightAction) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun NoteTopBarScreenPreview() {
    NoteTakingTheme(dynamicColor = false) {
        NoteTopBar(rememberCoroutineScope(), rememberDrawerState(DrawerValue.Closed))
    }
}

@Composable
@Preview(showSystemUi = true)
fun InputNoteTopBarScreenPreview() {
    NoteTakingTheme(dynamicColor = false) {
        InputNoteTopBar({}, {})
    }
}