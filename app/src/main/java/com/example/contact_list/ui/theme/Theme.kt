package com.example.contact_list.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = LightPink,        // TextBoxes, Buttons
    secondary = White,          // Just used for card backgr
    primaryContainer = Grey,    // Floating btn bckgr
    onPrimaryContainer = White, // Text on floating btn
    background = Pink,          // App background
    surface = Iron,             // Top bar bckgr
    onSurface = Black           // Text on cards
)

private val LightColorScheme = lightColorScheme(
    primary = LightPink,        // TextBoxes, Buttons
    secondary = White,          // Just used for card backgr
    primaryContainer = Grey,    // Floating btn bckgr
    onPrimaryContainer = White, // Text on floating btn
    background = Pink,          // App background
    surface = Iron,             // Top bar bckgr
    onSurface = Black           // Text on cards
)

@Composable
fun Contact_ListTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}