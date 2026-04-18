/**
 * ViewModel responsible for managing the list of contacts.
 *
 * Responsibilities:
 * - Stores the list of contacts
 * - Keeps contacts sorted alphabetically
 * - Adds new contacts
 * - Deletes contacts
 * - Updates existing contacts
 * - Finds a contact by its id
 *
 * This class contains the logic of the app (no UI).
 */
package com.example.contact_list.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.contact_list.model.Contact
import androidx.lifecycle.ViewModel
import com.example.contact_list.data.DataSource
import kotlin.collections.sortedWith
import kotlin.comparisons.compareBy


/* this folder should contain :
-  contactList
-  alphabetical sort
-  addContact()
-  deleteContact()
-  updateContact
-  getContactById()
*/
class ContactViewModel : ViewModel() {

    // Trier la liste de contacts en ordre alphabétique (prénom, ensuite nom)
    private var uiState by mutableStateOf(
        ContactUiState(
            contacts = DataSource.loadData()
                .sortedWith(compareBy({ it.prenom.lowercase() }, { it.nom.lowercase() }))
        )
    )
    val contacts: List<Contact>
        get() = uiState.contacts


    // Mettre la liste de contacts à jour
    fun updateList(newList: List<Contact>) {
        uiState = uiState.copy(
            contacts = newList.sortedWith(
                compareBy(
                    { it.nom.lowercase() },
                    { it.prenom.lowercase() })
            )
        )
    }
    // Récupérer un contact avec son ID
    fun getContactById(id: Int): Contact? {
        return uiState.contacts.find { it.id == id }
    }


    // Mettre un contact à jour
    fun updateContact(updatedContact: Contact) {
        updateList(uiState.contacts.map { if (it.id == updatedContact.id) updatedContact else it })
    }


    // Ajouter un contact
    fun addContact(contact: Contact) {
        val contactList = uiState.contacts.toMutableList()
        if (contact.id == 0) {
            val newId = (contactList.maxByOrNull { it.id }?.id ?: 0) + 1
            contactList.add(contact.copy(id = newId))
            updateList(contactList)
        } else {
            updateContact(contact)
        }
    }

    // Supprimer un contact
    fun deleteContact(contact: Contact) {
        updateList(uiState.contacts.filter { it.id != contact.id })
    }
}