package com.design.composechili.components.cell.baseCell

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

/**
 * TODO (add shimmer effect)
 * @param [title] accept [String] and showing on the start in cell
 * @param [subtitle] accept [String] and showing on the start and below [title] in cell
 * @param [isChevronVisible] u can set visibility state of chevron which will show on the end in cell
 * @param [isDividerVisible] u can set visibility state of divider which will show on the bottom in cell
 * @param [startIcon] accept [DrawableRes] and set [Image] on the start in cell
 * @param [baseCellParams] cell visual transformation params and paddings
 * @sample BaseCellParams.Default
 */

@Composable
fun BaseCell(
    modifier: Modifier = Modifier,
    title: String = String(),
    subtitle: String = String(),
    isChevronVisible: Boolean = false,
    isDividerVisible: Boolean = false,
    @DrawableRes startIcon: Int? = null,
    baseCellParams: BaseCellParams = BaseCellParams.Default,
) {
    Box(
        modifier
            .clip(baseCellParams.cornerMode.toRoundedShape())
            .background(Color.White)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            if (startIcon != null) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(dimensionResource(id = R.dimen.view_32dp)),
                    painter = painterResource(id = startIcon),
                    contentDescription = "Base cell start icon"
                )
            }
            Column(
                Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .padding(end = 16.dp)
            ) {

                val cellBottomPadding = if (subtitle.isBlank()) {
                    dimensionResource(id = R.dimen.padding_12dp)
                } else {
                    dimensionResource(id = R.dimen.padding_4dp)
                }

                Text(
                    text = title,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(
                            baseCellParams.titlePadding
                                .copy(bottom = cellBottomPadding)
                                .toPaddingValues()
                        ),
                    style = baseCellParams.titleTextStyle,
                )

                if (subtitle.isNotBlank()) {
                    Text(
                        text = subtitle,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(baseCellParams.subtitlePadding.toPaddingValues()),
                        style = baseCellParams.subTitleTextStyle
                    )
                }
            }

            if (isChevronVisible) {
                Image(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.chili_ic_chevron),
                    contentDescription = "Navigation icon",
                    colorFilter = ColorFilter.tint(
                        baseCellParams.chevronIconTint, BlendMode.SrcIn
                    )
                )
            }
        }
        if (isDividerVisible) {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                color = ChiliTheme.Colors.ChiliDividerColor,
                thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
            )
        }
    }
}

@Preview
@Composable
fun BaseCellPreview(){
    ChiliTheme{
        BaseCell(
            title = "Test",
            subtitle = "TestSubtitle",
            isChevronVisible = true,
            isDividerVisible = false,
        )
    }
}
