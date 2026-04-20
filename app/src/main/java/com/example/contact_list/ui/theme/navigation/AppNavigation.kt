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
package com.example.contact_list.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contact_list.ui.theme.screens.AddContactScreen
import com.example.contact_list.ui.theme.screens.ContactDetailsScreen
import com.example.contact_list.ui.theme.screens.ContactListScreen
import com.example.contact_list.ui.theme.screens.EditContactScreen
import com.example.contact_list.viewmodel.ContactViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: ContactViewModel = viewModel()

    NavHost(
        navController = navController,
        // pour tester temporairement
        Routes.CONTACT_LIST
    ) {
        composable(Routes.CONTACT_LIST) {
            ContactListScreen(
                contacts = viewModel.contacts,
                onDelete = { contact ->
                    viewModel.deleteContact(contact)
                },
                onAddClick = {
                    navController.navigate(Routes.ADD_CONTACT)
                },
                onEditClick = { contactId ->
                    navController.navigate("${Routes.EDIT_CONTACT}/$contactId")
                },
                onDetailsClick = { contactId ->
                    navController.navigate("${Routes.CONTACT_DETAILS}/$contactId")
                }
            )
        }

        composable(Routes.ADD_CONTACT) {
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

        composable(
            route = "${Routes.EDIT_CONTACT}/{contactId}",
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

        composable(
            route = "${Routes.CONTACT_DETAILS}/{contactId}",
            arguments = listOf(
                navArgument("contactId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getInt("contactId")
            val contact = contactId?.let { viewModel.getContactById(it) }

            if (contact != null) {
                ContactDetailsScreen(
                    contact = contact,
                    onEditClick = {
                        navController.navigate("${Routes.EDIT_CONTACT}/${contact.id}")
                    }
                )
            }
        }
    }
}