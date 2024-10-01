package com.design.composechili.theme.textStyle

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.TextUnit
import com.design.composechili.R

object ChiliTextStyle {

    fun get(
        textSize: TextUnit = TextUnit.Unspecified,
        color: Color = Color.Unspecified,
        font: Font = Font(R.font.roboto_regular),
    ): TextStyle {
        return TextStyle(
            fontSize = textSize,
            color = color,
            fontFamily = font.toFontFamily(),
        )
    }


}