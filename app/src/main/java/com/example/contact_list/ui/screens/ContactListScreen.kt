/**
 * Main screen displaying the list of contacts.
 *
 * UI responsibilities:
 * - Shows all contacts in a scrollable list (LazyColumn)
 * - Displays each contact using ContactItem
 * - Allows deleting a contact
 * - Allows navigating to Add screen
 * - Allows navigating to Edit screen
 *
 * This is the first screen shown when the app starts.
 */

package com.example.contact_list.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contact_list.model.Contact
import com.example.contact_list.ui.components.ContactItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(
    contacts: List<Contact>,
    onDelete: (Contact) -> Unit,
    onAddClick: () -> Unit,
    // int car il va prendre le id du contact
    onEditClick: (Int) -> Unit,
    onContactClick: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact List") }
            ) },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            } }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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