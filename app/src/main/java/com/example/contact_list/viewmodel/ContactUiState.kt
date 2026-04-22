/* ÉTAT DE LA LISTE */
package com.example.contact_list.viewmodel

import com.example.contact_list.model.Contact

data class ContactUiState(
    val contacts : List<Contact> = emptyList()
)