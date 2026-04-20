/**
 * Entry point of the application.
 *
 * Responsibilities:
 * - Launches the app
 * - Applies the theme
 * - Starts the navigation system
 *
 * This file should stay simple (no business logic here).
 */
package com.example.contact_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.contact_list.ui.theme.navigation.AppNavigation
import com.example.contact_list.ui.theme.Contact_ListTheme
import com.example.contact_list.ui.theme.screens.ContactDetailsScreen
import com.example.contact_list.model.Contact





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Contact_ListTheme {
                AppNavigation()
            }
        }
    }
}