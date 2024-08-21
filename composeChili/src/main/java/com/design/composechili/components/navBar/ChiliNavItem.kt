package com.design.composechili.components.navBar

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliColors
import com.design.composechili.theme.ChiliTextDimensions
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

@Composable
fun ChiliNavItem(
    text: String = String(),
    @DrawableRes selectedIcon: Int,
    @DrawableRes unselectedIcon: Int,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {

    val icon = if (isSelected) selectedIcon else unselectedIcon
    val textColor =
        if (isSelected) ChiliColors.defaultLightColors().chiliLinkTextColor else ChiliColors.defaultLightColors().chiliValueTextColor
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val sizeScale by animateFloatAsState(
        targetValue = if (isPressed) 1.2f else 1f,
        label = "Button Animation",
        animationSpec = spring(dampingRatio = 1f, stiffness = Spring.StiffnessLow)
    )

    Column(
        modifier = Modifier
            .offset(y = (-15).dp)
            .graphicsLayer(
                scaleX = sizeScale,
                scaleY = sizeScale
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            modifier = Modifier
                .background(
                    color = ChiliColors.defaultLightColors().chiliSurfaceBackground,
                    shape = RoundedCornerShape(
                        ChiliRadiusDimensions.fromResources().radius12Dp,
                    )
                )
                .padding(10.dp),
            painter = rememberVectorPainter(ImageVector.vectorResource(id = icon)),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = text,
            style = ChiliTextStyle.get(
                textSize = ChiliTextDimensions.fromResources().TextSizeH10,
                color = ChiliColors.defaultLightColors().chiliSegmentedPickerTabTextColor,
                fontWeight = FontWeight.Bold
            ),
            color = textColor
        )
    }
}