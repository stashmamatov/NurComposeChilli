package com.design.composechili.components.common.switch

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme

@Composable
fun ChiliSwitch(
    modifier: Modifier = Modifier,
    checkedState: Boolean,
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp),
    description: String = "Switch animation on items",
    onValueChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = description,
            color = ChiliTheme.Colors.ChiliValueTextColor
        )
        Switch(
            checked = checkedState,
            onCheckedChange = {
                onValueChange(it)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = ChiliTheme.Colors.ChiliSwitchBoxCheckedToggleColor,
                uncheckedThumbColor = ChiliTheme.Colors.ChiliSwitchBoxUncheckedToggleColor,
                checkedTrackColor = ChiliTheme.Colors.ChiliSwitchBoxCheckedBackground,
                uncheckedTrackColor = ChiliTheme.Colors.ChiliSwitchBoxUncheckedBackground
            )
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Switch_Preview() {
    ChiliTheme {
        var checkedState by remember {
            mutableStateOf(false)
        }
        Row(Modifier.background(ChiliTheme.Colors.ChiliSurfaceBackground)) {
            ChiliSwitch(checkedState = checkedState) {
                checkedState = it
            }
        }
    }
}