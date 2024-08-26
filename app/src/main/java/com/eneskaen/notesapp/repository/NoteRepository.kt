package com.eneskaen.notesapp.repository

import androidx.room.Query
import com.eneskaen.notesapp.database.NoteDatabase
import com.eneskaen.notesapp.model.Note

class NoteRepository(private  val db : NoteDatabase) {

    suspend fun insertNote(note : Note) = db.getNoteDao().insertNote(note)

    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()

    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)

}