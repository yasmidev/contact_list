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

import com.example.contact_list.model.Contact
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

// ------------ ContactViewModel -----------------
// va contenir la liste de contacts pis les fonctions pour les modifier
class ContactViewModel : ViewModel() {

    // state list pour ajouter, supprimer et modifier des contacts
    private val listContacts = mutableStateListOf(
        Contact(1, "Tremblay", "Alex", "Ubisoft", "514-333-4444", "514-555-6666", "alex.tremblay@ubisoft.com", "Montréal"),
        Contact(2, "Nguyen", "Linh", "Google", "438-111-2222", "438-333-4444", "linh.nguyen@gmail.com", "Laval"),
        Contact(3, "Smith", "John", "Microsoft", "514-777-8888", "514-999-0000", "john.smith@microsoft.com", "Toronto"),
        Contact(4, "Dubois", "Camille", "Desjardins", "418-111-3333", "418-222-4444", "camille.dubois@desjardins.com", "Québec"),
        Contact(5, "Garcia", "Maria", "Amazon", "514-123-4567", "514-765-4321", "maria.garcia@amazon.com", "Montréal"),
        )

    // ---------- getter sortedlist --------------
    // la liste qui est sorted par ordre alphabétique, la liste affichée
    // rapel :pour aceder il faut que tu fais viewModel.contacts
    val contacts: List<Contact>
        get() = listContacts.sortedWith(compareBy({
            it.nom.lowercase() },
            { it.prenom.lowercase() }))

    // ------------ add contact ---------------
    fun addContact(contact: Contact) {
        if (contact.id == 0) {
            // va générer le prochain ID disponible
            val newId = (listContacts.maxByOrNull { it.id }?.id ?: 0) + 1
            listContacts.add(contact.copy(id = newId))
        } else {
            updateContact(contact)
        }
    }


    // ------------- delete contact --------------
    fun deleteContact(contact: Contact) {
        listContacts.remove(contact)
    }



    // ------------ update contact --------------
    fun updateContact(updatedContact: Contact) {
        val index = listContacts.indexOfFirst { it.id == updatedContact.id }
        if (index != -1) {
            listContacts[index] = updatedContact
        }
    }

    // ------------ getter -----------
    fun getContactById(id: Int): Contact? {
        return listContacts.find { it.id == id }
    }
}