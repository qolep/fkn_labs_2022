package com.example.effective_lab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import dev.chrisbanes.snapper.*

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun Snap(heroes: List<Hero>,navController: NavHostController) {
    val lazyListState = rememberLazyListState()



    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center,

        ) {
        LazyRow(
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(
                lazyListState = lazyListState,
                snapOffsetForItem = SnapOffsets.Center,
            ),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {

            itemsIndexed(heroes) { index, hero ->
                Layout(
                    content = {
                        Box(
                            Modifier.fillMaxSize()
                        ) {
                            HeroCard(hero, heroes.indexOf(hero), navController)
                        }

                    },
                    measurePolicy = { measurables, constraints ->
                        val placeable = measurables.first().measure(constraints)
                        val maxWidthInPx = maxWidth.roundToPx()
                        val itemWidth = placeable.width
                        val startSpace =
                            if (index == 0) (maxWidthInPx - itemWidth) / 2 else 0
                        val endSpace =
                            if (index == heroes.size - 1) (maxWidthInPx - itemWidth) / 2 else 0
                        val width = startSpace + placeable.width + endSpace
                        layout(width, placeable.height) {
                            val x = if (index == 0) startSpace else 0
                            placeable.place(x, 0)
                        }
                    }
                )
            }
        }
    }
}