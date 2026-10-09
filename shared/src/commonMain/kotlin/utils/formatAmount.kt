package utils

import kotlin.math.abs

/** Converts amount to formatted string. Assumes pounds by default. */
fun formatAmount(amount: Long): String {
    val absAmount = abs(amount)
    val pounds = absAmount / 100
    val pence = absAmount % 100

    val poundsString = pounds.toString()
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
    val penceString = pence.toString().padStart(2, '0')

    return "£$poundsString.$penceString"
}