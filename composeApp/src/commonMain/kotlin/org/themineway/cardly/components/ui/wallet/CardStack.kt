package org.themineway.cardly.components.ui.wallet

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import org.themineway.cardly.lib.datatypes.wallet.ProviderCard
import org.themineway.cardly.lib.utils.generic.array.pick

const val MAX_VISIBLE_CARDS = 3;

@Composable
fun CardStack(cards: Iterable<ProviderCard>) {
    val selectedCard = remember { mutableStateOf(0) }

    val visibleCards: List<ProviderCard> = cards.pick(amount = MAX_VISIBLE_CARDS, startAt = selectedCard.value, loop = true);

    Column {
        Box(
            modifier = Modifier.height((48).dp)
        )
        Box(modifier = Modifier) {
            visibleCards.forEachIndexed { index, card ->
                val reverseIndex = visibleCards.size - 1 - index

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .graphicsLayer {
                            translationY = (reverseIndex * -48).toFloat() // vertical stack
                            scaleX = 1f - (reverseIndex * 0.03f)
                            scaleY = 1f - (reverseIndex * 0.03f)
                        }
                        .align(Alignment.TopCenter),
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(card.name)
                    }
                }
            }
        }
    }
}