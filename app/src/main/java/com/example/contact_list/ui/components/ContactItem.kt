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
package com.example.contact_list.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contact_list.model.Contact


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactItem(
    contact: Contact,
    onDelete: (Contact) -> Unit,
    onEdit: (Contact) -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = { expanded = !expanded },
                onLongClick = { onContactClick() }
            ),
        shape = RoundedCornerShape(40.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "${contact.prenom} ${contact.nom}",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
            if (expanded) {
                Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = contact.mobile.ifEmpty { contact.telephone },
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth(0.6F)
                    )
                    Row {
                        TextButton(onClick = { onEdit(contact) }) {
                            Text(text = "Edit")
                        }
                        Spacer(modifier = Modifier.width(8.dp))

                        TextButton(onClick = { onDelete(contact) }) {
                            Text(text = "Delete")
                        }
                    }
                }
            }
        }
    }
}