package com.example.contact_list.ui.theme.navigation

import kotlinx.serialization.Serializable

class AppNavigation {
    @Serializable
    object contactListScreen : AppNavigation()
    @Serializable
    object addContactScreen : AppNavigation()
    @Serializable
    object editContactScreen : AppNavigation()
    @Serializable
    object contactDetailsScreen : AppNavigation()
}


    val navController = rememberNavController()

        // we must addContactScreen button and the done
    NavHost(navController = navController, startDestination = AppNavigation.contactListScreen) {
        composable(AppNavigation.contactListScreen) {
            ContactListScreen(navController)
        }
        composable(AppNavigation.addContactScreen) {
            AddContactScreen(navController)
        }
        composable(AppNavigation.editContactScreen) {
            EditContactScreen(navController)
        }

}