package com.maulana.notetaking.di.module

import com.maulana.notetaking.datasource.local.NoteLocalDataSource
import com.maulana.notetaking.datasource.local.NoteLocalDataSourceImpl
import com.maulana.notetaking.domain.repository.NoteRepository
import com.maulana.notetaking.domain.repository.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.realm.kotlin.Realm

@Module
@InstallIn(ViewModelComponent::class)
object NoteModule {

    @Provides
    fun provideNoteRepository(noteLocalDataSource: NoteLocalDataSource): NoteRepository {
        return NoteRepositoryImpl(noteLocalDataSource)
    }

    @Provides
    fun provideNoteLocalDataSource(realm: Realm): NoteLocalDataSource {
        return NoteLocalDataSourceImpl(realm)
    }

}