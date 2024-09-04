package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.R
import com.design.composechili.components.cell.AdditionalDoubleButtons
import com.design.composechili.components.cell.AdditionalTextCellView
import com.design.composechili.components.cell.AdditionalTextCellViewList
import com.design.composechili.components.cell.model.AdditionalTextCellViewItems
import com.design.composechili.components.input.inputFieldWithDescAndAction.InputFieldWithDescAndAction
import com.design.composechili.components.tooltip.ChiliTooltip
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember {
                SnackbarHostState()
            }

            var maskedValueState by remember {
                mutableStateOf(String())
            }

            ChiliTheme {
                Column {
                    Spacer(modifier = Modifier.height(80.dp))
                    ChiliTooltip(
                        title = "Услуга Где Дети",
                        subtitle = "Услуга Где Дети Описание ",
                        requesterView = { clickListenerModifier ->
                            InputFieldWithDescAndAction(
                                descriptionModifier = clickListenerModifier,
                                description = "Test description",
                                actionTitle = "Test Action"
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    value = "Test Message",
                                    onValueChange = {})
                            }
                        },
                    )
                }
                Column(
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AdditionalTextCellView(
                        title = "Длинный текст ",
                        description = "Текст значения выходящий за свои рамки своей вместимости",
                        chevronEnabled = true,
                    )
                    AdditionalTextCellView(
                        title = "Заголовок",
                        description = "Additional text no chevron",
                        chevronEnabled = false
                    )
                    AdditionalTextCellView(
                        title = "Заголовок",
                        description = "Additional text icon",
                        icon = R.drawable.ic_darkmode_false_,
                        chevronEnabled = true,
                    )
                    AdditionalTextCellViewList(
                        itemsList = listOf(
                            AdditionalTextCellViewItems(
                                text = "simple",
                                description = "Value"
                            ),
                            AdditionalTextCellViewItems(
                                text = "simple",
                                description = "Value"
                            ),
                            AdditionalTextCellViewItems(
                                text = "simple",
                                description = "Value"
                            ),
                        )
                    )
                    AdditionalTextCellView(
                        title = "simple",
                        description = "Value",
                        subTitle = "123123",
                        subDescription = "Sub text 123",
                        icon = R.drawable.ic_bonus_new,
                        chevronEnabled = false,
                    )
                    AdditionalDoubleButtons(
                        title = "Заголовок",
                        positiveTitle = "ОПЛАТИТЬ",
                        negativeTitle = "ОТМЕНИТЬ"
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}