package com.buddy.budgetbuddy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
                .background(color = MaterialTheme.colorScheme.background),
        ) {

            TitleBar("Monthly Budget")

            BoxWithConstraints(
                modifier = Modifier
                    .safeContentPadding()
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
            ) {
                Overview()
                Income()
                Expenses()
            }
        }
    }
}


@Composable
fun TitleBar(title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                .padding(vertical = 12.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Composable
fun Overview() {}

@Composable
fun Income() {}

@Composable
fun Expenses() {}


