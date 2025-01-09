package com.maulana.notetaking.datasource.local.realm.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class NoteRealm : RealmObject {
    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var content: String = ""

}