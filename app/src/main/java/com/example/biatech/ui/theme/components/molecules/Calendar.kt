package com.example.biatech.ui.theme.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

@Composable
fun Calendar() {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val daysOfWeek = listOf("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС")

    val firstDayOfCurrentMonth = selectedDate.with(TemporalAdjusters.firstDayOfMonth())
    val firstVisibleDate =
        firstDayOfCurrentMonth.minusDays(firstDayOfCurrentMonth.dayOfWeek.ordinal % 7L)
    val daysInMonthMatrix = Array(6) { week ->
        Array(7) { day ->
            firstVisibleDate.plusDays((week * 7 + day).toLong())
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            // Кнопка "Предыдущий месяц"
            IconButton(onClick = { selectedDate = selectedDate.minusMonths(1) }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Предыдущий месяц")
            }

            Text(
                text = selectedDate.month.name + " " + selectedDate.year,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(horizontal = 8.dp),
                textAlign = TextAlign.Center
            )

            // Кнопка "Следующий месяц"
            IconButton(onClick = { selectedDate = selectedDate.plusMonths(1) }) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Следующий месяц")
            }
        }

        Row {
            for (day in daysOfWeek) {
                Text(
                    text = day,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        for (week in daysInMonthMatrix) {
            Row {
                for (day in week) {
                    val isCurrentMonth = day.month == selectedDate.month
                    Text(
                        text = day.dayOfMonth.toString(),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .clickable(onClick = { if (isCurrentMonth) selectedDate = day }),
                        textAlign = TextAlign.Center,
                        color = when {
                            !isCurrentMonth -> MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
                            day == selectedDate -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.onBackground
                        }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewCalendar() {
    Calendar()
}
