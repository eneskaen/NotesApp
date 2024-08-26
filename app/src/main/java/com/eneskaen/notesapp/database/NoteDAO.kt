package com.eneskaen.notesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.eneskaen.notesapp.model.Note

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("select * from notes order by id desc")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("select * from notes where noteTitle like :query or noteBody like :query")
    fun searchNote(query: String?) : LiveData<List<Note>>


}