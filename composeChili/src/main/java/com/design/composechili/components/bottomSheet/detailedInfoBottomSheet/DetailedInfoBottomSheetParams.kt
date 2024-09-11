package com.design.composechili.components.bottomSheet.detailedInfoBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class DetailedInfoBottomSheetParams(
    val textStyle: TextStyle,
    val iconSize: Dp
) {
    companion object {
        val Default
            @Composable get() = DetailedInfoBottomSheetParams(
                textStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                iconSize = dimensionResource(id = R.dimen.view_72dp)
            )
        val Custom
            @Composable get() = DetailedInfoBottomSheetParams(
                textStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                iconSize = dimensionResource(id = R.dimen.view_125dp)
            )
    }
}