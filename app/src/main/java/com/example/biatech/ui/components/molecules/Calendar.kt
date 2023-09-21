package com.example.biatech.ui.components.molecules

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.biatech.R

import com.example.biatech.ui.components.atom.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Calendar() {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    val firstDayOfCurrentMonth = selectedDate.with(TemporalAdjusters.firstDayOfMonth())
    val firstVisibleDate =
        firstDayOfCurrentMonth.minusDays(firstDayOfCurrentMonth.dayOfWeek.ordinal % 7L)
    val daysInMonthMatrix = Array(6) { week ->
        Array(7) { day ->
            firstVisibleDate.plusDays((week * 7 + day).toLong())
        }
    }
    Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {

        Column(modifier = Modifier.padding(bottom = 16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Кнопка "Предыдущий месяц"
                IconButton(onClick = { selectedDate = selectedDate.minusMonths(1) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.right_arrow),
                        contentDescription = "Предыдущий месяц"
                    )
                }

                Text(
                    text = selectedDate.month.name + " " + selectedDate.year,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 8.dp),
                    textAlign = TextAlign.Center
                )

                // Кнопка "Следующий месяц"
                IconButton(onClick = { selectedDate = selectedDate.plusMonths(1) }) {
                    Icon(
                        painterResource(id = R.drawable.right_arrow),
                        modifier = Modifier.rotate(180f),
                        contentDescription = "Следующий месяц"
                    )
                }
            }
            DayOfWeek()
            for (week in daysInMonthMatrix) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 3.dp)
                        .bottomBorder(1.dp, Color.LightGray),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (day in week) {
                        val isCurrentMonth = day.month == selectedDate.month
                        Card(
                            shape = RoundedCornerShape(5.dp),
                            modifier = Modifier
                                .padding(top = 5.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            )
                        ) {
                            Text(
                                text = day.dayOfMonth.toString(),
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .width(20.dp)
                                    .height(18.dp)
                                    .clickable(onClick = {
                                        if (isCurrentMonth) selectedDate = day
                                    }),
                                textAlign = TextAlign.Center,
                                color = when {
                                    !isCurrentMonth -> MaterialTheme.colorScheme.onBackground.copy(
                                        alpha = 0.3f
                                    )

                                    day == selectedDate -> MaterialTheme.colorScheme.primary
                                    else -> MaterialTheme.colorScheme.onBackground
                                },
                            )
                        }
                    }
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewCalendar() {
    Calendar()
}

fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx/2

            drawLine(
                color = color,
                start = Offset(x = 0f, y = height),
                end = Offset(x = width , y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)