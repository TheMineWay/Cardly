package org.themineway.cardly.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(navigateToTestCard: () -> Unit) {
    Column {
        Text("Home");
        Button(onClick = navigateToTestCard) {
            Text("Nav to test card")
        };
    }
}