/**
 * Screen used to add a new contact.
 *
 * Features:
 * - Displays input fields (name, phone, email, etc.)
 * - Lets the user enter new contact information
 * - Calls onSave() when the user confirms
 * - Calls onCancel() to go back without saving
 *
 * Navigation:
 * - Opened from ContactListScreen
 */
package com.example.contact_list.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contact_list.model.Contact
import androidx.compose.ui.Alignment




@OptIn(ExperimentalSubclassOptIn::class)
@Composable
fun AddContactScreen(
    onSave: (Contact) -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Add Contact")

        // quand tu appui sur le bouton, il doit trouver le dernier id et lui ajouter 1
            Button(
                onClick = {
                onSave(
                    Contact (
                        id = 0,
                        nom = "test",
                        prenom = "test",
                        entreprise = "test",
                        telephone = "000-0000",
                        mobile = "000-0000",
                        email = "test@email.com",
                        adresse = "test",
                        photo = ""
                )
                )
            }
            ) // il faut ajouter quelque chose dans le bouton pour quil soit valide
            {
                Text("Save")
            }

        Button(onClick = onCancel) {
            Text("Cancel")
        }


    }

}
