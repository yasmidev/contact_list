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
package com.example.contact_list.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contact_list.model.Contact
import androidx.compose.ui.Alignment


@OptIn(ExperimentalSubclassOptIn::class, ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(
    onSave: (Contact) -> Unit,
    onCancel: () -> Unit
) {
    var photo by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }
    var nom by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var telephone by remember { mutableStateOf("") }
    var entreprise by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var adresse by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ajouter un contact") }
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
            TextBox(value = photo, onValueChange = { photo = it }, label = "Photo")
            TextBox(value = prenom, onValueChange = { prenom = it }, label = "Prénom")
            TextBox(value = nom, onValueChange = { nom = it }, label = "Nom")
            TextBox(value = mobile, onValueChange = { mobile = it }, label = "Mobile")
            TextBox(value = telephone, onValueChange = { telephone = it }, label = "Téléphone")
            TextBox(value = entreprise, onValueChange = { entreprise = it }, label = "Entreprise")
            TextBox(value = email, onValueChange = { email = it }, label = "Email")
            TextBox(value = adresse, onValueChange = { adresse = it }, label = "Adresse")

            // quand tu appui sur le bouton, il doit trouver le dernier id et lui ajouter 1
            Button(
                onClick = {
                    onSave(
                        Contact(
                            id = 0,
                            nom = nom,
                            prenom = prenom,
                            entreprise = entreprise,
                            telephone = telephone,
                            mobile = mobile,
                            email = email,
                            adresse = adresse,
                            photo = photo
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
}