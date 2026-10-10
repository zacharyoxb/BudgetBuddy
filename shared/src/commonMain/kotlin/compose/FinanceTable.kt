package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import data.FinanceEvent
import utils.formatAmount

const val AMBER = 0xFFFF7025

@Composable
fun FinanceTable(events: List<FinanceEvent>) {
    LazyColumn(Modifier.fillMaxWidth()) {
        item {
            TableHeader()
        }
        items(events.size) {
            FinanceRow(events[it])
        }
        item {
            TableFooter()
        }
    }
}

@Composable
private fun TableHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.onPrimaryContainer, RectangleShape)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text("Label",  Modifier.weight(1.2f), style = MaterialTheme.typography.labelMedium)
        Text("Expected", Modifier.weight(1f), style = MaterialTheme.typography.labelMedium)
        Text("Actual", Modifier.weight(1f), style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
private fun FinanceRow(event: FinanceEvent) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .border(width = Dp.Hairline, color = MaterialTheme.colorScheme.onSecondaryContainer, RectangleShape)
            .clickable { /* edit */ }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(event.label, Modifier.weight(1.2f), style = MaterialTheme.typography.bodyMedium)
        Text(formatAmount(event.expected), Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
        Text(
            formatAmount(event.actual ?: event.expected),
            Modifier
                .weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            color = if (event.actual == null) {
                Color(AMBER)
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        )
    }
}


@Composable
private fun TableFooter() {
    Row(
        Modifier
            .fillMaxWidth(0.25f)
            .padding(top = 5.dp)
            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer, RectangleShape)
            .padding(horizontal = 16.dp, vertical = 3.dp),
    ) {
        Text("Add Entry", style = MaterialTheme.typography.labelMedium)
    }
}