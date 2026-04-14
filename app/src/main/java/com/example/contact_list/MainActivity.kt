package com.example.contact_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import com.example.contact_list.ui.theme.Contact_ListTheme
import com.example.contact_list.ui.theme.screens.ContactListScreen
import com.example.contact_list.viewmodel.ContactViewModel
import androidx.compose.ui.Modifier


class MainActivity : ComponentActivity() {

    private val viewModel: ContactViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Contact_ListTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ContactListScreen(
                        contacts = viewModel.contacts,
                        onDelete = { contact ->
                            viewModel.deleteContact(contact)
                        },
                        onAddClick = {
                            //ajout a faire
                        }
                    )
                }
            }
        }
    }
}