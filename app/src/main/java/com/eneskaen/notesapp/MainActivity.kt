package com.eneskaen.notesapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.eneskaen.notesapp.database.NoteDatabase
import com.eneskaen.notesapp.databinding.ActivityMainBinding
import com.eneskaen.notesapp.repository.NoteRepository
import com.eneskaen.notesapp.viewmodel.NoteViewModel
import com.eneskaen.notesapp.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory)
            .get(NoteViewModel::class.java)
    }
}