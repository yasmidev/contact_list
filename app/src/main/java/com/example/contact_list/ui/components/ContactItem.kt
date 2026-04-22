/* COMPOSABLE POUR CHAQUE CARTE DE CONTACT */
package com.example.contact_list.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.contact_list.model.Contact

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
            containerColor = MaterialTheme.colorScheme.secondary,
        )
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(contact.photo),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp).padding(end = 10.dp)
                )
                    Text(
                        text = "${contact.prenom} ${contact.nom}",
                    )
            }
            if (expanded) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = contact.mobile.ifEmpty { contact.telephone },
                        modifier = Modifier.fillMaxWidth(0.5F).padding(start = 8.dp)
                    )
                    Row {
                        TextButton(onClick = { onEdit(contact) }) {
                            Text(text = "Edit")
                        }
                        TextButton(onClick = { onDelete(contact) }) {
                            Text(text = "Delete")
                        }
                    }
                }
            }
        }
    }
}