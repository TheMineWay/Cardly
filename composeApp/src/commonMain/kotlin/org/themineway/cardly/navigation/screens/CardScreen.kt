package org.themineway.cardly.navigation.screens

import androidx.compose.runtime.Composable
import org.themineway.cardly.components.ui.wallet.CardStack
import org.themineway.cardly.lib.datatypes.wallet.ProviderCardModel

@Composable
fun CardScreen(cardId: String) {
    val mockCards = arrayOf(ProviderCardModel(0, "Demo1", "1234"), ProviderCardModel(2, "Demo2", "5678"), ProviderCardModel(3, "Demo4", "abcd"), ProviderCardModel(4, "Demo4", "efgh")).asIterable();
    CardStack(mockCards);
}