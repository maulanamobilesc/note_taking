package com.maulana.notetaking.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import com.maulana.notetaking.domain.HomeIntent
import com.maulana.notetaking.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _notes = MutableStateFlow<RealmList<NoteRealm>>(realmListOf())
    val notes: StateFlow<RealmList<NoteRealm>> = _notes

    fun processIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.GetAllNotes -> getAllNotes()
        }
    }

    private fun getAllNotes() {
        viewModelScope.launch(dispatcher) {
            runCatching {
                noteRepository.getAllNotes()
            }.onFailure {

            }.onSuccess {
                _notes.value = it
            }
        }
    }

}