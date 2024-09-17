package com.design.composechili.components.input.baseInput

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.design.composechili.R

@Composable
fun BaseInput(
    modifier: Modifier = Modifier,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    hint: String = String(),
    isEnabled: Boolean = true,
    isError: Boolean = false,
    params: BaseInputParams = BaseInputParams.Default,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null
) {
    Row (verticalAlignment = Alignment.CenterVertically){
        if (startIcon != null) {
            Image(
                painter = painterResource(id = startIcon),
                contentDescription = "Input field start description icon",
                modifier = modifier
                    .wrapContentSize()
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_8dp),
                        top = dimensionResource(id = R.dimen.padding_8dp),
                        bottom = dimensionResource(id = R.dimen.padding_8dp)
                    )
            )
        }
        TextField(
            modifier = modifier
                .wrapContentSize()
                .weight(1f)
                .fillMaxWidth()
                .padding(params.textFieldPadding),
            value = textFieldValue,
            onValueChange = onValueChange,
            textStyle = params.textStyle,
            enabled = isEnabled,
            isError = isError,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = params.keyboardType),
            shape = CircleShape.copy(CornerSize(8.dp)),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = params.fieldBackground,
                unfocusedContainerColor = params.fieldBackground,
                disabledContainerColor = params.fieldBackground,
                errorTextColor = params.errorTextColor,
                errorIndicatorColor = Color.Transparent,
                errorCursorColor = params.errorTextColor,
                textSelectionColors = TextSelectionColors(
                    params.cursorColor,
                    params.selectionBackgroundColor
                ),
                cursorColor = params.cursorColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = params.textStyle,
                    color = params.hintColor,
                    modifier = modifier.animateContentSize()
                )
            }

        )
        if (endIcon != null) {
            Image(
                painter = painterResource(id = endIcon),
                contentDescription = "Input field end description icon",
                modifier = modifier
                    .wrapContentSize()
                    .padding(
                        end = dimensionResource(id = R.dimen.padding_8dp),
                        top = dimensionResource(id = R.dimen.padding_8dp),
                        bottom = dimensionResource(id = R.dimen.padding_8dp)
                    )
            )
        }
    }
}