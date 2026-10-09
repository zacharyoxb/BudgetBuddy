package com.buddy.budgetbuddy

import data.FinanceEvent
import kotlinx.datetime.LocalDate


class TableTests {
    val values = sequenceOf(
        FinanceEvent(
            id = 1L,
            label = "Salary",
            date = LocalDate(2026, 3, 1),
            expected = 240_000,
        ),
        FinanceEvent(
            id = 2L,
            label = "Electricity",
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
}