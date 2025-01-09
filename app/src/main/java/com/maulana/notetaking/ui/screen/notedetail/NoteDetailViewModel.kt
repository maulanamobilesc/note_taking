package com.maulana.notetaking.ui.screen.notedetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import com.maulana.notetaking.domain.NoteIntent
import com.maulana.notetaking.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    val title = mutableStateOf("")
    val content = mutableStateOf("")

    private var note: NoteRealm? = null

    private val _errorMessage: MutableSharedFlow<String> = MutableSharedFlow()
    val errorMessage: SharedFlow<String> = _errorMessage


    fun processIntent(intent: NoteIntent) {
        when (intent) {
            is NoteIntent.SaveNote -> saveNote()
            is NoteIntent.GetNoteById -> getNoteById(intent.id)
            is NoteIntent.DeleteNote -> deleteNote()
        }
    }

    private fun getNoteById(id: String) {
        viewModelScope.launch(dispatcher) {
            runCatching {
                noteRepository.getNoteById(id)
            }.onFailure {
                _errorMessage.emit(it.localizedMessage.orEmpty())
            }.onSuccess {
                note = it
                title.value = it.title
                content.value = it.content
            }
        }
    }


    private fun saveNote() {
        viewModelScope.launch(dispatcher) {
            runCatching {
                if (title.value.isEmpty() && content.value.isEmpty()) {
                    throw Exception("Empty note cannot be saved")
                } else {
                    if (note == null) {
                        noteRepository.insertNote(NoteRealm().apply {
                            title = this@NoteDetailViewModel.title.value
                            content = this@NoteDetailViewModel.content.value
                        })
                    } else if (note!!.title != title.value || note!!.content != content.value) {
                        noteRepository.insertNote(NoteRealm().apply {
                            title = this@NoteDetailViewModel.title.value
                            content = this@NoteDetailViewModel.content.value
                            id = note!!.id
                        })
                    }
                }
            }.onFailure {
                _errorMessage.emit(it.localizedMessage.orEmpty())
            }.onSuccess {
                _errorMessage.emit("Note saved successfully")
            }
        }
    }

    private fun deleteNote() {
        viewModelScope.launch(dispatcher) {
            runCatching {
                noteRepository.deleteNote(note!!)
            }.onFailure {
                _errorMessage.emit(it.localizedMessage.orEmpty())
            }.onSuccess {
                _errorMessage.emit("Note deleted successfully")
            }
        }
    }
}

