package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import data.FinanceEvent
import utils.formatAmount

const val AMBER = 0xFFFFB300

@Composable
fun FinanceTable(events: List<FinanceEvent>) {
    LazyColumn(Modifier.fillMaxWidth()) {
        item {
            TableHeader()
        }
        items(events.size) {
            FinanceRow(events[it])
        }
    }
}

@Composable
private fun TableHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text("Date",   Modifier.weight(1.5f), style = MaterialTheme.typography.labelMedium)
        Text("Label",  Modifier.weight(2f), style = MaterialTheme.typography.labelMedium)
        Text("Expected", Modifier.weight(1f), style = MaterialTheme.typography.labelMedium)
        Text("Actual", Modifier.weight(1f), style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
private fun FinanceRow(event: FinanceEvent) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { /* edit */ }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(event.date.toString(), Modifier.weight(2f))
        Text(event.label, Modifier.weight(1.5f))
        Text(formatAmount(event.expected), Modifier.weight(1f))
        Text(
            formatAmount(event.actual ?: event.expected),
            Modifier.weight(1f),
            textAlign = TextAlign.End,
            color = if (event.actual == null) {
                Color(AMBER)
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        )
    }
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}
