package com.maulana.notetaking.datasource.local

import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmList
import org.mongodb.kbson.ObjectId
import javax.inject.Inject

class NoteLocalDataSourceImpl @Inject constructor(private val realm: Realm) : NoteLocalDataSource {

    override suspend fun insertNote(note: NoteRealm) {
        realm.write {
            if (note.id.isEmpty()) {
                note.id = ObjectId().toString()
            }
            copyToRealm(note, updatePolicy = UpdatePolicy.ALL)
        }
    }

    override fun getAllNotes(): RealmList<NoteRealm> {
        return realm.query<NoteRealm>().find().toRealmList()
    }

    override fun getNoteById(id: String): NoteRealm {
        return realm.query<NoteRealm>("id == $0", id).first().find()!!
    }

    override suspend fun updateNote(note: NoteRealm) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: NoteRealm) {
        realm.write {
            findLatest(note)?.let { delete(it) }
        }
    }

    override fun searchNote(query: String): RealmList<NoteRealm> {
        return realm.query<NoteRealm>("title CONTAINS[c] $0 OR content CONTAINS[c] $0", query).find().toRealmList()
    }
}