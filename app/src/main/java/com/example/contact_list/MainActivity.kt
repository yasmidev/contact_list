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
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.contact_list.navigation.AppNavigation
import com.example.contact_list.ui.theme.Contact_ListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("STATE", "onCreate")
        setContent {
            Contact_ListTheme {
                AppNavigation()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("STATE", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("STATE", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("STATE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("STATE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("STATE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("STATE", "onDestroy")
    }
}