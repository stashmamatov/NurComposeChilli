package com.design.composeChilli

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerDialog
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerParams
import com.design.composechili.components.picker.chiliDatePicker.DatePickerTimeParams
import com.design.composechili.components.picker.chiliTimePicker.ChiliTimePickerDialog
import com.design.composechili.R
import com.design.composechili.components.BaseSnackBar
import com.design.composechili.components.cell.BaseCell
import com.design.composechili.components.cell.BaseCellParams
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.components.navBar.NavBarWithFab
import com.design.composechili.components.navBar.model.ChiliNavItems
import com.design.composechili.components.slider.ChiliSlider
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember {
                SnackbarHostState()
            }
            var stiffnessValue by remember { mutableFloatStateOf(0f) }
            var animationValue by remember { mutableFloatStateOf(0f) }

            ChiliTheme {
                var alertDialogState by rememberSaveable { mutableStateOf(true) }
                var banner by rememberSaveable { mutableStateOf(String()) }

                Column {
                    Spacer(modifier = Modifier.size(80.dp))
                    BaseButton(onClick = {
                        alertDialogState = !alertDialogState
                    }, title = "Show dialog")
                }

                if (alertDialogState) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        ChiliDatePickerDialog(
                Scaffold(
                    bottomBar = {
                        NavBarWithFab(
                            animationSize = animationValue,
                            stiffness = stiffnessValue,
                            items = listOf(
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_home_filled,
                                    unselectedIcon = R.drawable.ic_home,
                                    text = "Главная"
                                ),
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_payment_filled,
                                    unselectedIcon = R.drawable.ic_payment,
                                    text = "Платежи"
                                ),
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_scaner_48,
                                    unselectedIcon = R.drawable.ic_scaner_48,
                                    isFab = true
                                ),
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_history_filled,
                                    unselectedIcon = R.drawable.ic_history,
                                    text = "История"
                                ),
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_menu_filled,
                                    unselectedIcon = R.drawable.ic_menu,
                                    text = "Ещё"
                                ),
                            ),
                            navigate = { }
                        )
                    },
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackbarHostState,
                            modifier = Modifier,
                            onDismissRequest = {},
                            startDateTitle = "Начальная Дата",
                            endDateTitle = "Конечная Дата",
                            submitBtnTitle = "Готово",
                            datePickedParams = ChiliDatePickerParams(
                                firstDate = DatePickerTimeParams(
                                    startDateTime = LocalDateTime.now(),
                                    minDateTime = LocalDateTime.of(2020, 1, 1, 10,0),
                                    maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0)
                                ),
                                secondDate = DatePickerTimeParams(
                                    startDateTime = LocalDateTime.now(),
                                    minDateTime = LocalDateTime.of(2020, 1, 1, 10,0),
                                    maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0),
                                )
                            ),
                            onSubmitBtn = { startDate, endDate ->

                            }
                        )
                    }
                }

            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = name, modifier = modifier)
                            Row() {
                                Spacer(modifier = Modifier.size(24.dp))
                                BaseCell(
                                    modifier = Modifier.weight(1f),
                                    title = "SecondTestTitle",
                                    isChevronVisible = true,
                                    isDividerVisible = true,
                                    baseCellParams = BaseCellParams.Default.copy(cornerMode = CellCornerMode.Middle)
                                )
                                Spacer(modifier = Modifier.size(24.dp))
                            }
                            Row() {
                                Spacer(modifier = Modifier.size(24.dp))
                                BaseCell(
                                    modifier = Modifier.weight(1f),
                                    title = "ThirdTestTitle",
                                    subtitle = "ThirdTestSubtitle",
                                    isChevronVisible = true,
                                    isDividerVisible = true,
                                    baseCellParams = BaseCellParams.Default.copy(cornerMode = CellCornerMode.Bottom)
                                )
                                Spacer(modifier = Modifier.size(24.dp))
                            }
                            Column(
                                Modifier
                                    .padding(16.dp)
                                    .background(Color.White)
                            ) {
                                ChiliSlider(description = "Animation size $animationValue") { animationValue = it }
                                ChiliSlider(
                                    description = "Stiffness value $stiffnessValue",
                                    stepsSize = 9,
                                    range = 0f..1000f
                                ) { stiffnessValue = it }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}