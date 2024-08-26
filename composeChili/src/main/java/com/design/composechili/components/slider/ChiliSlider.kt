package com.design.composechili.components.slider

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliColors
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChiliSlider(
    description: String = String(),
    stepsSize: Int = 0,
    range: ClosedFloatingPointRange<Float> = 0f..4f,
    onValueChanged: (Float) -> Unit = {},
) {

    var sliderValueState by remember { mutableFloatStateOf(0.0f) }
    val interactionSource = remember { MutableInteractionSource() }
    val text = description.ifBlank {
        "Spring animation float value ${
            String.format(
                Locale.ROOT,
                "%.1f",
                sliderValueState
            )
        }"
    }
    val onPress by interactionSource.collectIsDraggedAsState()
    val thumbSize by animateDpAsState(
        targetValue = if (onPress) 24.dp else 20.dp,
        label = "Thumb Animation",
        animationSpec = tween(300)
    )

    Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
        Text(
            text = text,
            color = ChiliColors.defaultLightColors().chiliValueTextColor
        )
        Slider(
            value = sliderValueState,
            onValueChange = { sliderValueState = it },
            track = { sliderState ->
                SliderDefaults.Track(
                    sliderState = sliderState,
                    colors = SliderDefaults.colors(
                        activeTrackColor = ChiliColors.defaultLightColors().chiliLinkTextColor,
                        inactiveTickColor = ChiliColors.defaultLightColors().chiliValueTextColor,
                        disabledInactiveTickColor = Color.Black,
                        activeTickColor = Color.Black,
                        disabledActiveTickColor = Color.Black
                    )
                )
            },
            interactionSource = interactionSource,
            steps = stepsSize,
            onValueChangeFinished = { onValueChanged(sliderValueState) },
            valueRange = range,
            thumb = {
                Spacer(
                    Modifier
                        .size(thumbSize)
                        .padding(4.dp)
                        .indication(
                            interactionSource = interactionSource,
                            indication = rememberRipple(bounded = false, radius = 15.dp)
                        )
                        .background(
                            ChiliColors.defaultLightColors().chiliLinkTextColor,
                            RoundedCornerShape(20.dp)
                        )
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChiliSlider_Preview() {
    Column {
        ChiliSlider(stepsSize = 9)
        ChiliSlider()
    }
}