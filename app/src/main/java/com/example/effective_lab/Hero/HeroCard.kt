package com.example.effective_lab

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun HeroCard(
    hero: Hero,
    index: Int,
    navController: NavHostController
) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(23.dp)
           .clickable { navController.navigate(route = Destination.HeroInfoScreen.passID(index)) },

    )
    {
        Image(
            painter = painterResource(id = hero.image),
            contentDescription = hero.description,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(350.dp, 550.dp)
                .clip(RoundedCornerShape(10))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = hero.name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}