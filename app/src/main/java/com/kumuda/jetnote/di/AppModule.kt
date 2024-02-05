package com.kumuda.jetnote.di

import android.content.Context
import androidx.room.Room
import com.kumuda.jetnote.data.NoteDatabase
import com.kumuda.jetnote.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(
            context = context,
            klass = NoteDatabase::class.java,
            name = "notes_db"
        )
            .fallbackToDestructiveMigration().build()


}