/* FICHIER POUR RÉUTILISER DES COMPOSABLES */
package com.example.contact_list.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contact_list.ui.theme.White

// Champ de text en mode lecture
@Composable
fun NonEditableTextBox(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth(0.7f),
        singleLine = singleLine,
        readOnly = true
    )
}

// Champ de text modifiable
@Composable
fun TextBox(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    isError: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth(0.7f),
        singleLine = singleLine,
        isError = isError,
    )
}

// Top Bar
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(text: String) {
    TopAppBar(
        title = { Text(text, modifier = Modifier.padding(start = 16.dp)) },
        expandedHeight = 118.dp
    )
}