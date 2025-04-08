package org.themineway.cardly.components.ui.wallet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.themineway.cardly.models.wallet.ProviderCardModel

const val CARD_CONTENT_PADDING = 8;
const val CARD_HEADER_HEIGHT = 22;
const val CARD_HEIGHT = 128;

fun getYOffset(index: Int): Int {
    return (index * -1 * (CARD_HEIGHT - (CARD_HEADER_HEIGHT + (CARD_CONTENT_PADDING * 2))));
}

@Composable
fun CardStack(cards: Iterable<ProviderCardModel>) {
    Column {
        cards.forEachIndexed { index, card -> run {
                Card (modifier = Modifier.fillMaxWidth().height(CARD_HEIGHT.dp).offset(x = 0.dp, y = getYOffset(index).dp)) {
                    // Card content
                    Box(modifier = Modifier.padding(CARD_CONTENT_PADDING.dp)) {
                        // Header
                        Box(modifier = Modifier.height(CARD_HEADER_HEIGHT.dp)) {
                            Text(card.name)
                        }
                    }
                }
            }
        }
    }
}