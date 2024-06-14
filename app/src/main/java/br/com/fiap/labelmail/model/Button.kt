package br.com.fiap.labelmail.model

import androidx.compose.ui.graphics.Color

data class Button(
    val label: String,
    val iconId: Int,
    val containerColor: Color,
    val tintColor: Color
)