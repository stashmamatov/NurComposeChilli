package com.design.composechili.components.cell.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R

data class CellIconSize(
    val iconSize: Dp = 0.dp,
    val verticalPadding: Dp = 0.dp,
    val horizontalPadding: Dp = 0.dp
) {

    companion object {

        val LARGE
            @Composable
            get() = CellIconSize(
                iconSize = dimensionResource(R.dimen.view_48dp),
                verticalPadding = dimensionResource(R.dimen.padding_14dp),
                horizontalPadding = dimensionResource(R.dimen.padding_12dp)
            )

        val MEDIUM
            @Composable
            get() = CellIconSize(
                iconSize = dimensionResource(R.dimen.view_46dp),
                verticalPadding = dimensionResource(R.dimen.padding_14dp),
                horizontalPadding = dimensionResource(R.dimen.padding_12dp)
            )

        val SMALL
            @Composable
            get() = CellIconSize(
                iconSize = dimensionResource(R.dimen.view_32dp),
                verticalPadding = dimensionResource(R.dimen.padding_8dp),
                horizontalPadding = dimensionResource(R.dimen.padding_12dp)
            )
    }
}