package com.maulana.notetaking.domain

sealed class NoteIntent {
    data object SaveNote : NoteIntent()
    data class GetNoteById(val id: String) : NoteIntent()
    data object DeleteNote : NoteIntent()
}
sealed class HomeIntent {
    data object GetAllNotes : HomeIntent()
}
