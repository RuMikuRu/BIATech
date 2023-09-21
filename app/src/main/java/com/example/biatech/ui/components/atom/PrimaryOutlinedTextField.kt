package com.example.biatech.ui.components.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneField(
    phone: String,
    modifier: Modifier = Modifier,
    mask: String = "000 000 00 00",
    maskNumber: Char = '0',
    onPhoneChanged: (String) -> Unit,
) {
    TextField(
        value = phone,
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 24.sp,
            color = Color(0xFF2B2D35),
        ),
        onValueChange = { it ->
            onPhoneChanged(it.take(mask.count { it == maskNumber }))
        },
        placeholder = {
            Text(
                text = "+7 (000)-000-00-00", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    color = Color(0xB8C4DB),
                )
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = PhoneVisualTransformation(mask, maskNumber),
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
        )
    )
}

class PhoneVisualTransformation(val mask: String, val maskNumber: Char) : VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PhoneVisualTransformation) return false
        if (mask != other.mask) return false
        if (maskNumber != other.maskNumber) return false
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}

@Preview
@Composable
fun PreviewPhoneField() {
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    PhoneField(
        phone = phoneNumber,
        mask = "+7 (000)-000-00-00",
        onPhoneChanged = { phoneNumber = it },
        maskNumber = '0'
    )
}