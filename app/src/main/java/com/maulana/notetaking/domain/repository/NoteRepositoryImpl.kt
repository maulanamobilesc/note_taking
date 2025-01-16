package com.maulana.notetaking.domain.repository

import com.maulana.notetaking.datasource.local.NoteLocalDataSource
import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import io.realm.kotlin.types.RealmList
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteLocalDataSource: NoteLocalDataSource) :
    NoteRepository {

    override suspend fun insertNote(note: NoteRealm) {
        return noteLocalDataSource.insertNote(note)
    }

    override fun getAllNotes(): RealmList<NoteRealm> {
        return noteLocalDataSource.getAllNotes()
    }

    override fun getNoteById(id: String): NoteRealm {
        return noteLocalDataSource.getNoteById(id)
    }

    override suspend fun updateNote(note: NoteRealm) {
        return noteLocalDataSource.updateNote(note)
    }

    override suspend fun deleteNote(note: NoteRealm) {
        return noteLocalDataSource.deleteNote(note)
    }

    override fun searchNote(query: String): RealmList<NoteRealm> {
        return noteLocalDataSource.searchNote(query)
    }
}