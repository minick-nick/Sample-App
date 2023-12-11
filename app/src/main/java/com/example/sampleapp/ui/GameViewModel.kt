package com.example.sampleapp.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.sampleapp.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState(numberToGuess = getRandomNumber()))
    val uiSate : StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    fun updateUserGuess(guessedNumber: String) {
        userGuess = guessedNumber
    }

    fun getRandomNumber(): Int {
        return (1..10).random()
    }

    fun checkAnswer(){
        val numberToGuess = _uiState.value.numberToGuess
        val guess = userGuess.toInt()

        _uiState.update {
            it.copy(
                hint = when {
                    guess == numberToGuess -> R.string.correct
                    guess > numberToGuess -> R.string.too_high
                    else -> R.string.too_low
                }
            )
        }
    }
}