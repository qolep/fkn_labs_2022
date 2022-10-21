package com.example.effective_lab

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun Snap(heroes: List<Hero>) {


    val lazyListState = rememberLazyListState()

    val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)
    val indexLazyList = remember{
        mutableStateOf(layoutInfo.currentItem?.index)
    }
    indexLazyList.value=layoutInfo.currentItem?.index

    //  println(layoutInfo.currentItem?.index)

    when(indexLazyList.value){

        0 -> BackgroundTriangle(Color.Black )
        1 -> BackgroundTriangle(Color.Yellow )
        2 -> BackgroundTriangle(Color.Blue )
        3 -> BackgroundTriangle(Color.White )
        4 -> BackgroundTriangle(Color.Magenta )
    }

//not working :( try mutableStateOf triangleColor


    LazyRow(
        state = lazyListState,
        flingBehavior = rememberSnapperFlingBehavior(layoutInfo),
    ) {
        items(items = heroes) { hero ->
            HeroCard(hero)
        }
    }
}