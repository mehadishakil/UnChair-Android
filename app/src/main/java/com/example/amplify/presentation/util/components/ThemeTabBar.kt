package com.example.amplify.presentation.util.components

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints

@Preview(showBackground = true)
@Composable
fun TabViewPreview() {
    ThemeTabBar()
}

enum class SubComposeID {
    PRE_CALCULATE_ITEM,
    ITEM,
    INDICATOR
}

data class TabPosition(
    val left: Dp, val width: Dp
)

@Composable
fun ThemeTabBar() {

    var selectedTabPosition by remember { mutableStateOf(0) }

    val items = listOf(
        "Default", "Light", "Dark"
    )

    val sequence = listOf(2, 1, 0)
    var index = 0
    LaunchedEffect(key1 = "", block = {
//        while (true) {
//            delay(1000)
//            selectedTabPosition = sequence[index]
//            index += 1
//            if (index >= 4) {
//                index = 0
//            }
//        }
    })

    TabRow(
        selectedTabPosition = selectedTabPosition
    ) {
        items.forEachIndexed { index, s ->
            TabTitle(s, position = index) { selectedTabPosition = index }
        }
    }
}

@Composable
fun TabRow(
    containerColor: Color = Color.LightGray,
    indicatorColor: Color = Color.White,
    containerShape: Shape = RoundedCornerShape(8.dp),
    indicatorShape: Shape = RoundedCornerShape(8.dp),
    paddingValues: PaddingValues = PaddingValues(8.dp),
    animationSpec: AnimationSpec<Dp> = tween(durationMillis = 750, easing = FastOutSlowInEasing),
    selectedTabPosition: Int = 0,
    tabItem: @Composable () -> Unit
) {

    Surface(
        color = containerColor,
        shape = containerShape
    ) {
        SubcomposeLayout(
            Modifier
                .padding(paddingValues)
                .selectableGroup()
        ) { constraints ->
            val tabMeasurable: List<Placeable> = subcompose(SubComposeID.PRE_CALCULATE_ITEM, tabItem)
                .map { it.measure(constraints) }

            val itemsCount = tabMeasurable.size
            val maxItemWidth = tabMeasurable.maxOf { it.width }
            val maxItemHeight = tabMeasurable.maxOf { it.height }

            val tabPlacables = subcompose(SubComposeID.ITEM, tabItem).map {
                it.measure(constraints)
            }

            val tabPositions = tabPlacables.mapIndexed { index, placeable ->
                val itemWidth = (constraints.maxWidth/itemsCount).toDp()
                val x = (constraints.maxWidth/itemsCount) * index
                TabPosition(x.toDp(), itemWidth)
            }

            layout(constraints.maxWidth, maxItemHeight) { // Use constraints.maxWidth
                subcompose(SubComposeID.INDICATOR) {
                    Box(
                        Modifier
                            .tabIndicator(tabPositions[selectedTabPosition], animationSpec)
                            .fillMaxWidth()
                            .height(maxItemHeight.toDp())
                            .background(color = indicatorColor, indicatorShape)
                    )
                }.forEach {
                    it.measure(Constraints.fixed(constraints.maxWidth, maxItemHeight)).placeRelative(0, 0)
                }

                tabPlacables.forEachIndexed { index, placeable ->
                    val x = (constraints.maxWidth/itemsCount) * index
                    placeable.placeRelative(x, 0)
                }
            }
        }
    }
}

fun Modifier.tabIndicator(
    tabPosition: TabPosition,
    animationSpec: AnimationSpec<Dp>,
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = tabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabPosition.width,
        animationSpec = animationSpec
    )
    val indicatorOffset by animateDpAsState(
        targetValue = tabPosition.left,
        animationSpec = animationSpec
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
        .fillMaxHeight()
}

@Composable
fun TabTitle(
    title: String,
    position: Int,
    onClick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp/3)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onClick(position) }
            ),
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
    }
}

