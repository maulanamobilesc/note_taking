package com.maulana.notetaking.ui.screen.notedetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.maulana.notetaking.core.component.TransparentTextField
import com.maulana.notetaking.domain.NoteIntent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NoteDetailScreen(
    id: String,
    navController: NavHostController,
    viewModel: NoteDetailViewModel = hiltViewModel(),
    snackBarState: SnackbarHostState
) {
    LaunchedEffect(id.isNotEmpty()) {
        viewModel.processIntent(NoteIntent.GetNoteById(id))
    }
    LaunchedEffect(Unit) {
        viewModel.errorMessage.collectLatest {
            snackBarState.showSnackbar(message = it, duration = SnackbarDuration.Long)
        }
    }
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            TransparentTextField(modifier = Modifier.fillMaxWidth(),
                value = viewModel.title.value,
                onValueChange = { viewModel.title.value = it },
                placeholder = { Text("Title") })
            TransparentTextField(modifier = Modifier.fillMaxWidth(),
                value = viewModel.content.value,
                onValueChange = { viewModel.content.value = it },
                placeholder = { Text("Content") })
        }
    }
}