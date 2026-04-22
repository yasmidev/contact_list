/* ÉCRAN POUR MODIFIER UN CONTACT */
package com.example.contact_list.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contact_list.model.Contact
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.res.painterResource
import com.example.contact_list.ui.components.TextBox
import com.example.contact_list.ui.components.TopBar

@Composable
fun EditContactScreen(contact: Contact, onSave: (Contact) -> Unit, onCancel: () -> Unit) {

    var photo by remember { mutableIntStateOf(contact.photo) }
    var prenom by remember { mutableStateOf(contact.prenom) }
    var nom by remember { mutableStateOf(contact.nom) }
    var mobile by remember { mutableStateOf(contact.mobile) }
    var telephone by remember { mutableStateOf(contact.telephone) }
    var entreprise by remember { mutableStateOf(contact.entreprise) }
    var email by remember { mutableStateOf(contact.email) }
    var adresse by remember { mutableStateOf(contact.adresse) }

    val prenomValide = prenom != ""
    val mobileValide = mobile == "" || mobile.length == 10
    val telephoneValide = telephone == "" || telephone.length == 10
    val emailValide = email == "" || (email.contains("@") && email.contains("."))
    val isValid = prenomValide && mobileValide && emailValide
    var error by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBar("Edit Contact")
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
            TextBox(
                value = prenom, onValueChange = { prenom = it }, label = "Prénom",
                isError = if (error) !prenomValide else false
            )
            TextBox(value = nom, onValueChange = { nom = it }, label = "Nom")
            TextBox(
                value = mobile, onValueChange = { mobile = it }, label = "Mobile",
                isError = if (error) !mobileValide else false
            )
            TextBox(
                value = telephone, onValueChange = { telephone = it }, label = "Téléphone",
                isError = if (error) !telephoneValide else false
            )
            TextBox(value = entreprise, onValueChange = { entreprise = it }, label = "Entreprise")
            TextBox(
                value = email, onValueChange = { email = it }, label = "Email",
                isError = if (error) !emailValide else false
            )
            TextBox(value = adresse, onValueChange = { adresse = it }, label = "Adresse")

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier.padding(bottom = 6.dp),
                onClick = {
                    if (isValid) {
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
                    } else {
                        error = true
                    }
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