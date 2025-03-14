package com.example.myschool.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = White,
    background = DarkGray,
    surface = CardDarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = Black,
    background = White,
    surface = CardLightGray
)

@Composable
fun MySchoolTheme(content: @Composable () -> Unit) {
    val colors = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
    MaterialTheme(colorScheme = colors, typography = Typography, content = content)
}
