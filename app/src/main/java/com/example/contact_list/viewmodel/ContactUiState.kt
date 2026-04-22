package com.example.contact_list.viewmodel

import com.example.contact_list.model.Contact

// This one should hold the UI state

// cest comme CarnetUIstate
data class ContactUiState(
    val contacts : List<Contact> = emptyList()
)