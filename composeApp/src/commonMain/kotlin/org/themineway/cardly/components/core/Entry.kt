package org.themineway.cardly.components.core

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import org.themineway.cardly.constants.Configuration
import org.themineway.cardly.i18n.Locales

@Composable
fun Entry() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(Configuration.APP_NAME) },
                backgroundColor = MaterialTheme.colors.background,
            )
        }) {
        Text(Locales.t("hello.Title"))
    }
}