/* ÉCRAN POUR AFFICHER LES INFOS D'UN CONTACT */
package com.example.contact_list.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.contact_list.model.Contact
import com.example.contact_list.ui.components.NonEditableTextBox
import com.example.contact_list.ui.components.TopBar

@Composable
fun ContactDetailScreen(contact: Contact, onCancel: () -> Unit) {

    Scaffold(
        topBar = {
            TopBar("Contact Details")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(contact.photo),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            NonEditableTextBox(value = contact.prenom, onValueChange = {}, label = "Prénom")
            NonEditableTextBox(value = contact.nom, onValueChange = {}, label = "Nom")
            NonEditableTextBox(value = contact.mobile, onValueChange = {}, label = "Mobile")
            NonEditableTextBox(value = contact.telephone, onValueChange = {}, label = "Téléphone")
            NonEditableTextBox(value = contact.entreprise, onValueChange = {}, label = "Entreprise")
            NonEditableTextBox(value = contact.email, onValueChange = {}, label = "Email")
            NonEditableTextBox(value = contact.adresse, onValueChange = {}, label = "Adresse")

            Button(onClick = onCancel) {
                Text("Back")
            }
        }
    }
}