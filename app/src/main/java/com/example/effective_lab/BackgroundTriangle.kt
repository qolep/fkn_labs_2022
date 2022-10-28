package com.example.effective_lab

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

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