package com.example.biatech.ui.components.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourDigitCodeField(
    onCodeChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var code by remember { mutableStateOf("") }
    TextField(
        value = code,
        onValueChange = {
            if (it.length <= 4) {
                code = it
                onCodeChanged.invoke(it)
            }
        },
        singleLine = true,
        maxLines = 1,
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color(0xFF3C4049),
                shape = RoundedCornerShape(size = 18.dp)
            )
            .height(60.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent, shape = RoundedCornerShape(size = 18.dp))
            .padding(start = 12.dp, top = 4.dp, end = 12.dp, bottom = 4.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            textColor = Color.Black,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 24.sp,
            color = Color(0xFF2B2D35),
        ),
    )
}

@Preview
@Composable
fun CodeField() {
    FourDigitCodeField(onCodeChanged = { code -> "2344" })
}
