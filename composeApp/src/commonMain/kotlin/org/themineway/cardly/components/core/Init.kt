package org.themineway.cardly.components.core

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import org.themineway.cardly.i18n.Locales

@Composable
fun Init() {
    val i18nData by produceState<Locales?>(initialValue = null) {
        value = Locales.init();
    }

    when (i18nData) {
        null -> Text("Loading");
        else -> Entry();
    }
}