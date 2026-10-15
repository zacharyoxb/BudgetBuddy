package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp.Companion.Hairline
import androidx.compose.ui.unit.dp
import data.FinanceEvent
import utils.formatAmount

//const val AMBER = 0xFFFF7025

@Composable
fun FinanceTable(tableName: String, events: List<FinanceEvent>, modifier: Modifier = Modifier) {
    val nameWeight = .4f
    val expectedCostWeight = .3f
    val actualCostWeight = .3f

    SectionHeader(tableName)

    Column(
        modifier = modifier
            .height(200.dp)
            .border(1.dp, color = MaterialTheme.colorScheme.outline)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            TableCell(text = "Item Name", weight = nameWeight)
            TableCell(text = "Cost (Expected)", weight = expectedCostWeight)
            TableCell(text = "Cost (Actual)", weight = actualCostWeight)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(events) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    TableCell(text = it.label, weight = nameWeight)
                    TableCell(text = formatAmount(it.expected), weight = expectedCostWeight)
                    TableCell(text = formatAmount(it.actual ?: it.expected), weight = actualCostWeight)

                }
            }
        }
    }
}


@Composable
private fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .fillMaxHeight()
            .weight(weight)
            .border(Hairline, color = MaterialTheme.colorScheme.outlineVariant)
            .padding(5.dp),
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )
}
