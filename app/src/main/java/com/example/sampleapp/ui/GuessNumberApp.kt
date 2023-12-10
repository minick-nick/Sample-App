package com.example.sampleapp.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sampleapp.R
import com.example.sampleapp.ui.theme.SampleAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuessNumberApp(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel = viewModel()
) {
    val gameUiState by gameViewModel.uiSate.collectAsState()

    Column(
        modifier = modifier
            .padding(10.dp)
    ) {
        Text(text = stringResource(R.string.life))
        Text(text = stringResource(R.string.hint))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
        ) {
            TextField(
                value = gameViewModel.userGuess,
                onValueChange = {
                    gameViewModel.updateUserGuess(it)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GuessNumberAppPreview() {
    SampleAppTheme {
        GuessNumberApp(modifier = Modifier.fillMaxSize())
    }
}