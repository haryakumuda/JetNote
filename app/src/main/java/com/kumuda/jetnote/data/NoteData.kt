package com.kumuda.jetnote.data

import androidx.room.Entity
import com.kumuda.jetnote.model.Note



class NotesDataSource {
    fun loadNotes(): List<Note> {
        val notes = mutableListOf<Note>()
        var i = 1
        while (i <= 5) {
            notes.add(Note(title = "Title - $i", description = "Description - $i"))
            i++
        }
        return notes

    }
}