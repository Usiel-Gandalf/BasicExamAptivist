package com.example.basic.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basic.viewModel.ResultViewModel

@Composable
fun ResultView(
    firstValue: String,
    operator: String,
    secondValue: String,
    returnToStart: () -> Unit,
    viewModel: ResultViewModel = viewModel()
) {

    LaunchedEffect(true) {
        viewModel.makeOperation(firstNumber = firstValue, secondNumber = secondValue, operator = operator)
    }

    val isPar = viewModel.state.collectAsState().value

    Column {
        whenIspar(
            isPar = isPar,
            viewModel.result,
            returnToStart = returnToStart
        )
    }
}

@Composable
fun whenIspar(
    isPar: Boolean,
    result: String,
    returnToStart: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(if (isPar) Color.Blue else Color.Red)
            .fillMaxSize()
    ) {
        if (isPar) {
            Text(text = "$result is a par number")
        } else {
            Text(text = "$result is not a par number")
        }

        Button(
            onClick = returnToStart
        ) {
            Text(text = "Regresar al Inicio")
        }
    }
}

@Composable
fun AddNumbers(firstNumber: Int, secondNumber: Int, result: Int? = null) {
    val result = firstNumber + secondNumber
    if (result % 2 == 0) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxSize()
        ) {
            Text(text = result.toString() + " is a entero number")
        }
    } else {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .fillMaxSize()
        ) {
            Text(text = result.toString() + " is not a entero number")
        }
    }

}