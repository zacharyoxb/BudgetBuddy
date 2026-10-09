package data

import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate

/** For events that have no end, use an infinite repeater */
data class InfiniteRepeater(
    val id: Long,
    val label: String,
    val expected: Long,
    val from: LocalDate,
    val interval: DatePeriod,
    val nInterval: Int
)

/** All finance events will be represented by this */
data class FinanceEvent(
    val id: Long,
    val label: String,
    val date: LocalDate,
    val expected: Long,
    val actual: Long? = null,
)
