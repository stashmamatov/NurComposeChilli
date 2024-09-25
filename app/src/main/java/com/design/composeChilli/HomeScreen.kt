package com.design.composeChilli

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.design.composeChilli.navigation.currentComposeNavigator
import com.design.composechili.components.buttons.baseButton.BaseButton

@Composable
fun HomeScreen() {

    val composeNavigator = currentComposeNavigator

    val homeScreenItems = listOf(
        Pair("Text Appearances", ChiliScreens.TextAppearance),
        Pair("Buttons", ChiliScreens.Buttons),
        Pair("Input fields", ChiliScreens.InputFields),
    )

    LazyColumn {
        item {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.cover),
                contentDescription = null
            )
        }
        items(homeScreenItems){
            Spacer(modifier = Modifier.size(24.dp))
            BaseButton(
                onClick = {
                    composeNavigator.navigate(it.second)
                }, title = it.first
            )
        }
    }

}