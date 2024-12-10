package com.maulana.notetaking.datasource.local.realm.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class NoteRealm : RealmObject {
    @PrimaryKey
    var id: String = ObjectId().toString()
    var title: String = ""
    var content: String = ""

}