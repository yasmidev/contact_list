/**
 * Handles navigation between screens.
 *
 * Responsibilities:
 * - Defines all routes (list, add, edit)
 * - Connects screens together using NavHost
 * - Passes data between screens (like contactId)
 * - Calls ViewModel functions when needed
 *
 * This is the "router" of the app.
 */

package com.example.contact_list.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contact_list.ui.screens.AddContactScreen
import com.example.contact_list.ui.screens.ContactDetailScreen
import com.example.contact_list.ui.screens.ContactListScreen
import com.example.contact_list.ui.screens.EditContactScreen
import com.example.contact_list.viewmodel.ContactViewModel


@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    viewModel: ContactViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Route.CONTACT_LIST
    ) {
        // Écran avec la liste de contacts
        composable(Route.CONTACT_LIST) {
            ContactListScreen(
                contacts = viewModel.contacts,
                onDelete = { contact ->
                    viewModel.deleteContact(contact)
                },
                onContactClick = { contactId ->
                    navController.navigate("${Route.DETAILED_CONTACT}/$contactId")
                },
                onAddClick = {
                    navController.navigate(Route.ADD_CONTACT)
                },
                onEditClick = { contactId ->
                    navController.navigate("${Route.EDIT_CONTACT}/$contactId")
                }
            )
        }

        // Écran avec les détails d'un contact
        composable(
            route = "${Route.DETAILED_CONTACT}/{contactId}",
            arguments = listOf(
                navArgument("contactId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getInt("contactId")
            val contact = contactId?.let { viewModel.getContactById(it) }

            if (contact != null) {
                ContactDetailScreen(
                    contact = contact,
                    onSave = { updatedContact ->
                        viewModel.updateContact(updatedContact)
                        navController.popBackStack()
                    },
                    onCancel = {
                        navController.popBackStack()
                    }
                )
            }
        }
        // Écran pour ajouter un contact
        composable(Route.ADD_CONTACT) {
            AddContactScreen(
                onSave = { contact ->
                    viewModel.addContact(contact)
                    navController.popBackStack()
                },
                onCancel = {
                    navController.popBackStack()
                }
            )
        }

        // Écran pour modifier un contact
        composable(
            route = "${Route.EDIT_CONTACT}/{contactId}",
            arguments = listOf(
                navArgument("contactId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getInt("contactId")
            val contact = contactId?.let { viewModel.getContactById(it) }

            if (contact != null) {
                EditContactScreen(
                    contact = contact,
                    onSave = { updatedContact ->
                        viewModel.updateContact(updatedContact)
                        navController.popBackStack()
                    },
                    onCancel = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}