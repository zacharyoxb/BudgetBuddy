package com.buddy.budgetbuddy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            TitleBar("Monthly Budget")

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Column(
                    modifier = Modifier
                        .widthIn(max = 600.dp)
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                ) {
                    Overview()
                    Income()
                    Expenses()
                }
            }
        }
    }
}

@Composable
fun TitleBar(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .statusBarsPadding()
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }
}

@Composable
fun Overview() {
    SectionHeader("Overview")
    // placeholder — replace with your content
}

@Composable
fun Income() {
    SectionHeader("Income")
}

@Composable
fun Expenses() {
    SectionHeader("Expenses")
}

@Composable
private fun SectionHeader(text: String) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        HorizontalDivider(
            modifier = Modifier.padding(top = 4.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
    }
}
