package com.design.composechili.components.input.password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder

@Immutable
data class PasswordInputParams(
    val textStyle: TextStyle,
    val errorTextColor: Color,
    val cursorColor: Color,
    val fieldBackground: Color,
    val fieldErrorBackground: Color,
    val selectionBackgroundColor: Color,
    val hintColor: Color,
    val endIconColor: Color,
    val keyboardType: KeyboardType,
    val imeAction: ImeAction,
) {

    companion object {
        val Default
            @Composable
            get() = PasswordInputParams(
                textStyle = ChiliTextStyleBuilder.H6.Primary.Medium,
                errorTextColor = ChiliTheme.Colors.ChiliErrorTextColor,
                cursorColor = colorResource(id = R.color.magenta_1),
                fieldBackground = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor,
                fieldErrorBackground = ChiliTheme.Colors.ChiliCodeInputItemErrorBackgroundColor,
                selectionBackgroundColor = colorResource(id = R.color.magenta_3),
                hintColor = colorResource(id = R.color.gray_1),
                endIconColor = ChiliTheme.Colors.ChiliInputEndIconTint,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            )
    }

}