package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text("Label",  Modifier.weight(1.5f), style = MaterialTheme.typography.labelMedium)
        Text("Expected", Modifier.weight(1f), style = MaterialTheme.typography.labelMedium)
        Text("Actual", Modifier.weight(1f), style = MaterialTheme.typography.labelMedium, textAlign = TextAlign.End)
    }
}

@Composable
private fun FinanceRow(event: FinanceEvent) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { /* edit */ },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(event.label, Modifier.weight(1.5f), style = MaterialTheme.typography.bodyMedium)
        Text(formatAmount(event.expected), Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
        Text(
            formatAmount(event.actual ?: event.expected),
            Modifier
                .weight(1f)
                .padding(5.dp),
            style = MaterialTheme.typography.bodyMedium,
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


@Composable
private fun TableFooter() {
    Row(
        Modifier
            .fillMaxWidth(0.25f)
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text("Add Entry", style = MaterialTheme.typography.labelMedium)
    }
}