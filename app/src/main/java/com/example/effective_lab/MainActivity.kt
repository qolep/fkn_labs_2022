package com.example.effective_lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            Screen()
        }
    }
}


@Composable
private fun Screen() {
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
                Snap(HeroList.heroes)
            }
        }
    }
}


@Composable
fun BackgroundTriangle(backgroundColor: Color) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val trianglePath = Path().apply {
            val height = size.height
            val width = size.width
            moveTo(width, height / 2)
            lineTo(0f, height)
            lineTo(width, height)
        }
        drawPath(trianglePath, color = backgroundColor)
    }
}



