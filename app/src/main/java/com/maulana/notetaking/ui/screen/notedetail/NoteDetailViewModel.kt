package com.maulana.notetaking.ui.screen.notedetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import com.maulana.notetaking.domain.NoteIntent
import com.maulana.notetaking.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    val title = mutableStateOf("")
    val content = mutableStateOf("")

    fun processIntent(intent: NoteIntent) {
        when (intent) {
            is NoteIntent.SaveNote -> saveNote()
            is NoteIntent.GetNoteById -> getNoteById(intent.id)
        }
    }

    private fun getNoteById(id: String) {
        viewModelScope.launch(dispatcher) {
            runCatching {
                noteRepository.getNoteById(id)
            }.onFailure {
                val test = ""
            }.onSuccess {
                title.value = it.title
                content.value = it.content
            }
        }
    }


    private fun saveNote() {
        viewModelScope.launch(dispatcher) {
            runCatching {
                noteRepository.insertNote(NoteRealm().apply {
                    title = this@NoteDetailViewModel.title.value
                    content = this@NoteDetailViewModel.content.value
                })
            }.onFailure {
                val test = ""
            }.onSuccess {
                val test2 = ""
            }
        }
    }

}