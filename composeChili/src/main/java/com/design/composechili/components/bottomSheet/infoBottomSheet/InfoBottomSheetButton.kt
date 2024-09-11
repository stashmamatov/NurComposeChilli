package com.design.composechili.components.bottomSheet.infoBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Stable
data class InfoBottomSheetButton(
    val onClick: () -> Unit,
    val title: String,
    val buttonStyle: ChiliButtonStyle
)

@Stable
data class InfoBottomSheetsParams(
    val titleStyle: TextStyle,
    val descriptionStyle: TextStyle,
    val maxChars: Int
) {
    companion object {
        private const val MAX_CHARS = 120
        val Default
            @Composable get() = InfoBottomSheetsParams(
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ),
                descriptionStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH4,
                    color = ChiliTheme.Colors.chiliErrorTextColor
                ),
                maxChars = MAX_CHARS
            )
    }
}