package org.themineway.cardly

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.themineway.cardly.components.core.Init


@Composable
@Preview
fun App() {
    MaterialTheme {
        Init()
    }
}