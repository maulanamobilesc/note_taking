package com.maulana.notetaking.domain.repository

import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import io.realm.kotlin.types.RealmList

interface NoteRepository {

    suspend fun insertNote(note: NoteRealm)

    fun getAllNotes(): RealmList<NoteRealm>

    fun getNoteById(id: String): NoteRealm

    suspend fun updateNote(note: NoteRealm)

    suspend fun deleteNote(note: NoteRealm)

}