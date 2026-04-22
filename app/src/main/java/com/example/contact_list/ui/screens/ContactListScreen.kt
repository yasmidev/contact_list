/* ÉCRAN POUR AVEC LA LISTE DE TOUT LES CONTACTS */
package com.example.contact_list.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contact_list.model.Contact
import com.example.contact_list.ui.components.ContactItem
import com.example.contact_list.ui.components.TopBar

@Composable
fun ContactListScreen(
    contacts: List<Contact>,
    onDelete: (Contact) -> Unit,
    onAddClick: () -> Unit,
    onEditClick: (Int) -> Unit,
    onContactClick: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar("Contacts")
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick, shape = RoundedCornerShape(40.dp)) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(contacts) { contact ->
                ContactItem(
                    contact = contact,
                    onDelete = onDelete,
                    onEdit = { onEditClick(contact.id) },
                    onContactClick = { onContactClick(contact.id) }
                )
            }
        }
    }
}