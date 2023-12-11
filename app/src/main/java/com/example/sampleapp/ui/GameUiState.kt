package com.example.sampleapp.ui

import androidx.annotation.StringRes
import com.example.sampleapp.R

data class GameUiState(
    val life: Int = 3,
    @StringRes val hint: Int = R.string.blank,
    val numberToGuess: Int
)
