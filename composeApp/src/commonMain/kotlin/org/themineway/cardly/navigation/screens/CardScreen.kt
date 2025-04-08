package org.themineway.cardly.navigation.screens

import androidx.compose.runtime.Composable
import org.themineway.cardly.components.ui.wallet.CardStack
import org.themineway.cardly.lib.datatypes.wallet.ProviderCard

@Composable
fun CardScreen(cardId: String) {
    val mockCards = arrayOf(ProviderCard(0, "Demo1", "1234"), ProviderCard(2, "Demo2", "5678"), ProviderCard(3, "Demo4", "abcd"), ProviderCard(4, "Demo4", "efgh")).asIterable();
    CardStack(mockCards);
}