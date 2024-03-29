package com.kumuda.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kumuda.jetnote.model.Note
import com.kumuda.jetnote.screen.NoteScreen
import com.kumuda.jetnote.screen.NoteViewModel
import com.kumuda.jetnote.ui.theme.JetNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteViewModel: NoteViewModel by viewModels()
//                    val noteViewModel = viewModel<NoteViewModel>() // also works
                    NotesApp(noteViewModel = noteViewModel)


                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel){
    val notesList = noteViewModel.noteList.collectAsState().value

    NoteScreen(notes = notesList,
        onRemove = {noteViewModel.removeNote(it)},
        onAddNote = {noteViewModel.addNote(it)},

        )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetNoteTheme {

    }
}