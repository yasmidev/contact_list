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


/* this folder should contain :
- contact list
-  alphabetical sort
-  addContact()
-  deleteContact()
-  updateContact
-  getContactById()
*/
class ContactViewModel : ViewModel() {
    private val list_contacts = mutableStateListOf(
        Contact(1, "Cabrera", "Yasmina", "EBGames", "111-1111", "222-2222", "yasmina@email.com", "Montreal", ""),
        Contact(2, "nom", "prenom", "Google", "333-3333", "444-4444", "nomprenom@email.com", "Laval", "")
    )
    val contacts: List<Contact>
        get() = list_contacts.sortedWith(compareBy({ it.nom.lowercase() }, { it.prenom.lowercase() }))

    fun addContact(contact: Contact) {
        list_contacts.add(contact)
    }

    fun deleteContact(contact: Contact) {
        list_contacts.remove(contact)
    }

    fun updateContact(updatedContact: Contact) {
        val index = list_contacts.indexOfFirst { it.id == updatedContact.id }
        if (index != -1) {
            list_contacts[index] = updatedContact
        }
    }

    fun getContactById(id: Int): Contact? {
        return list_contacts.find { it.id == id }
    }
}