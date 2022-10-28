package com.example.effective_lab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.effective_lab.Data.HeroList


@Composable
fun StartScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize()
    )
    {
        BackgroundTriangle(Color.Red)

        LazyColumn {
            item {
                Logo()
            }
            item {
                Snap(HeroList.heroes, navController = navController)
            }
        }
    }
}