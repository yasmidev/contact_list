/**
 * Data class representing a single contact.
 *
 * This class only stores data (no logic).
 * Each contact has an id and personal information.
 *
 * Used by:
 * - ViewModel (to manage contacts)
 * - UI (to display contact info)
 */

package com.example.contact_list.model
import com.example.contact_list.R


data class Contact(
    val id : Int,
    val nom : String,
    val prenom : String,
    val entreprise : String,
    val telephone : String,
    val mobile : String,
    val email : String,
    val adresse : String,
    val photo : Int = R.drawable.bluepfp
)
