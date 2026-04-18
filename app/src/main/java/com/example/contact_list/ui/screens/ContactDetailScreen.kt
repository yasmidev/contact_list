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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contact_list.model.Contact

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDetailScreen(
    contact: Contact,
    onSave: (Contact) -> Unit,
    onCancel: () -> Unit
) {
    var photo by remember { mutableStateOf(contact.photo) }
    var prenom by remember { mutableStateOf(contact.prenom) }
    var nom by remember { mutableStateOf(contact.nom) }
    var mobile by remember { mutableStateOf(contact.mobile) }
    var telephone by remember { mutableStateOf(contact.telephone) }
    var entreprise by remember { mutableStateOf(contact.entreprise) }
    var email by remember { mutableStateOf(contact.email) }
    var adresse by remember { mutableStateOf(contact.adresse) }

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
            TextBox(value = photo, onValueChange = { photo = it }, label = "Photo")
            TextBox(value = prenom, onValueChange = { prenom = it }, label = "Prénom")
            TextBox(value = nom, onValueChange = { nom = it }, label = "Nom")
            TextBox(value = mobile, onValueChange = { mobile = it }, label = "Mobile")
            TextBox(value = telephone, onValueChange = { telephone = it }, label = "Téléphone")
            TextBox(value = entreprise, onValueChange = { entreprise = it }, label = "Entreprise")
            TextBox(value = email, onValueChange = { email = it }, label = "Email")
            TextBox(value = adresse, onValueChange = { adresse = it }, label = "Adresse")

            Button(
                onClick = {
                    val updatedContact = contact.copy(
                        nom = nom,
                        prenom = prenom,
                        entreprise = entreprise,
                        telephone = telephone,
                        mobile = mobile,
                        email = email,
                        adresse = adresse,
                        photo = photo
                    )
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