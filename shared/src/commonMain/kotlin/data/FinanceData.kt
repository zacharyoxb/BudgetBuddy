package data

import androidx.compose.runtime.Composable
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.daysUntil
import kotlinx.datetime.number
import kotlinx.datetime.plus

/* Indicates how often the income or expense occurs */
sealed interface RecurrenceRule {
    data class NDays(val nDays: Int) : RecurrenceRule
    data object Monthly : RecurrenceRule
    data object Weekly : RecurrenceRule
    data object Yearly : RecurrenceRule
}

/* Indicates how often the event occurs. */
data class Recurrence(
    val rule: RecurrenceRule,
    val start: LocalDate,
    val end: LocalDate? = null,
)

/* Indicates whether the event repeats */
sealed interface Schedule {
    data class Once(val date: LocalDate) : Schedule
    data class Recurring(val recurrence: Recurrence) : Schedule
}

/* Full entry data type */
data class FinanceEntry(
    val id: String,
    val label: String,
    val amount: Long,
    val schedule: Schedule,
)

data class FinanceEvent(
    val id: String,
    val label: String,
    val amount: Long,
    val date: LocalDate,
)

private fun getOccurrenceN(date: LocalDate, rule: RecurrenceRule, n: Int): LocalDate =
    when (rule) {
        is RecurrenceRule.NDays -> date.plus(n * rule.nDays, DateTimeUnit.DAY)
        RecurrenceRule.Weekly  -> date.plus(n, DateTimeUnit.WEEK)
        RecurrenceRule.Monthly -> date.plus(n, DateTimeUnit.MONTH)
        RecurrenceRule.Yearly  -> date.plus(n, DateTimeUnit.YEAR)
    }

fun FinanceEntry.getFinanceEvents(from: LocalDate, until: LocalDate): List<FinanceEvent> =
    when (val s = schedule) {
        is Schedule.Once ->
            if (s.date in from..until) {
                listOf(FinanceEvent(id, label, amount, s.date))
            } else {
                emptyList()
            }

        is Schedule.Recurring -> {
            val r = s.recurrence
            val rangeEnd = minOf(r.end ?: until, until)
            val occurrences = mutableListOf<FinanceEvent>()

            var cursor = r.start

            var nOccurrence = 1
            while (cursor <= rangeEnd) {
                occurrences += FinanceEvent(id, label, amount, cursor)
                cursor = getOccurrenceN(r.start, r.rule, nOccurrence)
                nOccurrence += 1
            }

            occurrences
        }
    }