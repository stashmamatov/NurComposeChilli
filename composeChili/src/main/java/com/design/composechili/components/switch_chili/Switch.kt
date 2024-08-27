package com.design.composechili.components.switch_chili

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
fun SwitchChili() {
    ChiliTheme {
        var checkedState by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Switch animation on items",
                color = ChiliTheme.Colors.chiliValueTextColor
            )
            Switch(
                checked = checkedState,
                onCheckedChange = { checkedState = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = ChiliTheme.Colors.chiliLinkTextColor
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Switch_Preview() {
    SwitchChili()
}