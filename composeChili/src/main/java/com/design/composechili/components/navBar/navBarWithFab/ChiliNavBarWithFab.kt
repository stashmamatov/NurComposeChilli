package com.design.composechili.components.navBar.navBarWithFab

import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.components.navBar.navBarWithFab.model.ChiliNavButtonItem
import com.design.composechili.components.navBar.navBarWithFab.model.NavBarWithFabParams
import com.design.composechili.theme.ChiliTheme


/**
 * A navigation bar with an integrated floating action button (FAB), supporting navigation items
 * and optional FAB scale animation.
 *
 * @param navItems A list of `ChiliNavWithFab` objects that define the navigation items to be displayed in the navigation bar.
 * Each item can include an icon, label, and an optional FAB.
 *
 * @param isScaleAnimationEnabled A Boolean flag that determines whether the FAB should animate its scale when interacted with.
 * If `true`, the FAB will grow and shrink slightly during interactions for a smoother visual experience. Default is `true`.
 *
 * @param params  chili nav bar with floating action button - visual transformation params and paddings. Default is `NavBarWithFabParams.Default`
 *
 * @param onNavigateItemClicked A lambda function that is invoked when a navigation item or FAB is clicked.
 * The clicked `ChiliNavWithFab` item is passed to this lambda, enabling specific actions, such as navigation changes or UI updates.
 *
 * Example Usage:
 * ```
 * val navItems = listOf(
 *     ChiliNavWithFab(icon = R.drawable.ic_home, label = "Home", hasFab = true, selected = true),
 *     ChiliNavWithFab(icon = R.drawable.ic_profile, label = "Profile", hasFab = false, selected = false)
 * )
 *
 * ChiliNavBarWithFab(
 *     navItems = navItems,
 *     isFabScaleAnimation = true,
 *     onNavigateItemClicker = { navItem ->
 *         // Handle navigation or FAB item click
 *     }
 * )
 * ```
 *
 * @see [NavBarWithFabParams.Default]
 */

@Composable
fun ChiliNavBarWithFab(
    modifier: Modifier = Modifier,
    navItems: List<ChiliNavButtonItem>,
    isScaleAnimationEnabled: Boolean = true,
    scale:Float = 1.3f,
    scaleAnimationDuration:Int = DefaultDurationMillis,
    params: NavBarWithFabParams = NavBarWithFabParams.Default,
    onNavigateItemClicked: (ChiliNavButtonItem) -> Unit
) {
    var selectedItem by remember {
        mutableStateOf(
            navItems.filterIsInstance<ChiliNavButtonItem.ChiliNavButtonItemButton>().first()
        )
    }

    LazyRow(
        modifier = modifier
            .background(
                color = params.backgroundColor,
                shape = params.backgroundShape
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .windowInsetsPadding(NavigationBarDefaults.windowInsets)
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(navItems) { item ->
            when (item) {
                is ChiliNavButtonItem.ChiliNavButtonItemButton -> {
                    ChiliNavWithFabSimpleItem(
                        icon = item.icon,
                        isScaleAnimationEnabled = isScaleAnimationEnabled,
                        label = item.label,
                        scaleSize = scale,
                        scaleAnimationDuration = scaleAnimationDuration,
                        selected = selectedItem == item,
                    ) {
                        selectedItem = item
                        onNavigateItemClicked.invoke(item)
                    }
                }

                is ChiliNavButtonItem.ChiliNavButtonItemFloatActionButton -> {
                    ChiliNavFabItem(
                        isScaleAnimationEnabled = isScaleAnimationEnabled,
                        icon = item.icon,
                        animationDuration = scaleAnimationDuration,
                        scaleSize = scale
                    ) {
                        onNavigateItemClicked.invoke(item)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChiliNavBarWithFabPreview() {
    ChiliTheme {
        Scaffold(
            bottomBar = {
                ChiliNavBarWithFab(
                    navItems = listOf(
                        ChiliNavButtonItem.ChiliNavButtonItemButton(
                            icon = R.drawable.ic_home,
                            label = "Главная"
                        ),
                        ChiliNavButtonItem.ChiliNavButtonItemButton(
                            icon = R.drawable.ic_payment,
                            label = "Платежи"
                        ),
                        ChiliNavButtonItem.ChiliNavButtonItemFloatActionButton(
                            icon = R.drawable.ic_scaner_48
                        ),
                        ChiliNavButtonItem.ChiliNavButtonItemButton(
                            icon = R.drawable.ic_history,
                            label = "История"
                        ),
                        ChiliNavButtonItem.ChiliNavButtonItemButton(
                            icon = R.drawable.ic_menu,
                            label = "Ещё"
                        ),
                    ),
                    onNavigateItemClicked = { }
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.background(color = Color.Black)) {
                Image(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.ic_cat),
                    contentDescription = null
                )
            }
        }
    }
}