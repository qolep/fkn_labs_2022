package com.example.effective_lab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Logo() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.marvel),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp, 60.dp)
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter),
        )
        Text(
            "Choose your hero!",
            fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 40.dp)
                .offset(x=0.dp, y=35.dp)
        )
    }
}