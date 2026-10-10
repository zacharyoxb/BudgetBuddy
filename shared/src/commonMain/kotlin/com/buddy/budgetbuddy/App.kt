package com.buddy.budgetbuddy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import compose.FinanceTable
import compose.SectionHeader
import compose.TitleBar
import data.FinanceEvent
import kotlinx.datetime.LocalDate
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
fun Overview() {
    SectionHeader("Overview")
}

@Composable
fun Income() {
    SectionHeader("Income")

    val values = listOf(
        FinanceEvent(
            id = 1L,
            label = "Salary",
            date = LocalDate(2026, 3, 1),
            expected = 240_000,
        ),
        FinanceEvent(
            id = 2L,
            label = "Interest",
            date = LocalDate(2026, 3, 15),
            expected = 8_500,
            actual = 9_240,
        ),
        FinanceEvent(
            id = 3L,
            label = "Freelance",
            date = LocalDate(2026, 3, 20),
            expected = 40_000,
            actual = null,
        ),
    )
    FinanceTable(values)
}

@Composable
fun Expenses() {
    SectionHeader("Expenses")

    val values = listOf(
        FinanceEvent(
            id = 1L,
            label = "Bills",
            date = LocalDate(2026, 3, 1),
            expected = 24_000,
        ),
        FinanceEvent(
            id = 2L,
            label = "Food",
            date = LocalDate(2026, 3, 15),
            expected = 80_500,
            actual = 80_240,
        ),
        FinanceEvent(
            id = 3L,
            label = "Netflix",
            date = LocalDate(2026, 3, 20),
            expected = 12_00,
            actual = null,
        ),
    )
    FinanceTable(values)
}

