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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contact_list.model.Contact
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TopAppBar





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContactScreen(
    contact: Contact,
    onSave: (Contact) -> Unit,
    onCancel: () -> Unit
) {
    var nom by remember { mutableStateOf(contact.nom) }
    var prenom by remember { mutableStateOf(contact.prenom) }
    var entreprise by remember { mutableStateOf(contact.entreprise) }
    var telephone by remember { mutableStateOf(contact.telephone) }
    var mobile by remember { mutableStateOf(contact.mobile) }
    var email by remember { mutableStateOf(contact.email) }
    var adresse by remember { mutableStateOf(contact.adresse) }
    var photo by remember { mutableStateOf(contact.photo) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Modifier un contact") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nom,
                onValueChange = { nom = it },
                label = { Text("Nom") }

            )

            OutlinedTextField(
                value = prenom,
                onValueChange = { prenom = it },
                label = { Text("Prénom") }

            )

            OutlinedTextField(
                value = entreprise,
                onValueChange = { entreprise = it },
                label = { Text("Entreprise") }

            )

            OutlinedTextField(
                value = telephone,
                onValueChange = { telephone = it },
                label = { Text("Téléphone") }
            )

            OutlinedTextField(
                value = mobile,
                onValueChange = { mobile = it },
                label = { Text("Mobile") }
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )

            OutlinedTextField(
                value = adresse,
                onValueChange = { adresse = it },
                label = { Text("Adresse") }
            )

            OutlinedTextField(
                value = photo,
                onValueChange = { photo = it },
                label = { Text("Photo") }
            )

            Button(
                onClick = {
                    val updatedContact = contact.copy(nom = nom
                    , prenom = prenom
                    , entreprise = entreprise
                    , telephone = telephone
                    , mobile = mobile
                    , email = email
                    , adresse = adresse
                    , photo = photo)

                    onSave(updatedContact)
                }
            ) {
                Text("Save")
            }

            Button(onClick = onCancel) {
                Text("Cancel")
            }

        }
    }

}