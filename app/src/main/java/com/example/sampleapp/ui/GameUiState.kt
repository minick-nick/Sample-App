package com.example.sampleapp.ui

import androidx.annotation.StringRes
import com.example.sampleapp.R

data class GameUiState(
    val life: Int,
    @StringRes val hint: Int,
    val numberToGuess: Int,
    val isAnswerCorrect: Boolean = false
)
