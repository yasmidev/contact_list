package com.example.contact_list.model

data class Contact(
    val id : Int,
    val nom : String,
    val prenom : String,
    val entreprise : String,
    val telephone : String,
    val mobile : String,
    val email : String,
    val adresse : String,
    val photo : String = ""
)
