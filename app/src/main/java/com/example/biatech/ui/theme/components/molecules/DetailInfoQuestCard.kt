package com.example.biatech.ui.theme.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biatech.ui.theme.components.atom.PrimaryTextHeading
import com.example.biatech.ui.theme.components.atom.PrimaryTextHref

@Composable
fun DetailInfoQuestCard() {
    Card(shape = RoundedCornerShape(size = 18.dp), modifier = Modifier.padding(16.dp)) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            PrimaryTextHeading(text = "Тип груза")
            Text(text = "Мебель")
            PrimaryTextHeading(text = "Город исполнения")
            Text(text = "Моква")
            PrimaryTextHeading(text = "Дата заказа")
            Text(text = "18.04.2023")
            PrimaryTextHeading(text = "Время прибытия")
            Text(text = "12:00")
            PrimaryTextHeading(text = "Начальная точка маршрута")
            PrimaryTextHref(text = "Склад 51, Ул. Пушкина 124Б")
            PrimaryTextHeading(text = "Конечная точка маршрута")
            PrimaryTextHref(text = "Склад 38, Ул. Розенбаума 89")
            PrimaryTextHeading(text = "Тип кузова")
            Text(text = "Тентованный")
            PrimaryTextHeading(text = "Детали заказа")
            Text(text = "Прописанные детали заказа")
            PrimaryTextHeading(text = "Параметры по оплате")
            Text(text = "Прописанные параметры по оплате")
            PrimaryTextHeading(text = "Контакты")
            PrimaryTextHref(text = "+7 800 896 52 63")
            Text(text = "Иванов Владимир Иосифович")
        }
    }
}

@Preview
@Composable
fun PreviewDetailInfoQuestCard() {
    DetailInfoQuestCard()
}