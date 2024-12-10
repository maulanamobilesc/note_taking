package com.maulana.notetaking.datasource.local

import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import io.realm.kotlin.types.RealmList
import kotlinx.coroutines.flow.Flow

interface NoteLocalDataSource {

    suspend fun insertNote(note: NoteRealm)

    fun getAllNotes(): RealmList<NoteRealm>

    fun getNoteById(id: String): NoteRealm

    suspend fun updateNote(note: NoteRealm)

    suspend fun deleteNote(note: NoteRealm)

}