package com.maulana.notetaking.di.module

import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object RealmModule {

    @Provides
    fun provideRealm(): Realm {
        return Realm.open(
            RealmConfiguration.Builder(schema = setOf(NoteRealm::class)).schemaVersion(2)
                .build()
        )
    }

}