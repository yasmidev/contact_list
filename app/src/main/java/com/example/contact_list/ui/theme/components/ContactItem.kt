/**
 * Reusable UI component representing a single contact card.
 *
 * Features:
 * - Displays basic contact info (name + phone)
 * - Can expand to show more details (email, address, etc.)
 * - Has a delete button
 * - Has an edit button
 *
 * Used inside ContactListScreen.
 */
package com.example.contact_list.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contact_list.model.Contact


    @Composable
    fun ContactItem(
        contact: Contact,
        onDelete: (Contact) -> Unit,
        onEdit: (Contact) -> Unit,
        modifier: Modifier = Modifier) {

     var expanded by remember { mutableStateOf(false) }


        Card(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "${contact.nom} ${contact.prenom}",
                            style = MaterialTheme.typography.titleLarge)
                        Text(
                            text = contact.telephone,
                            style = MaterialTheme.typography.bodyMedium)
                    }

                    TextButton(onClick = { onEdit(contact) }) {
                        Text(text = "Edit")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    TextButton(onClick = { onDelete(contact) }) {
                        Text(text = "Delete")
                    }
                }
                if (expanded) {
                    Text(
                        text = "Entreprise : ${contact.entreprise}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Mobile : ${contact.mobile}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Email : ${contact.email}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Adresse : ${contact.adresse}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                }
            }
        }
    }