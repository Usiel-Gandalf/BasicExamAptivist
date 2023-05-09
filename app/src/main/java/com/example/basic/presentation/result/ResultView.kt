package com.example.basic.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basic.domain.OperationType
import com.example.basic.presentation.result.ResultViewModel

@Composable
fun ResultView(
    firstValue: String,
    operator: OperationType,
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
            .background(if (isPar) Color.LightGray else Color.Magenta)
            .fillMaxSize()
            .padding(start = 50.dp, top = 50.dp)

    ) {
        Row(modifier = Modifier.padding(bottom = 20.dp)) {
            if (isPar) {
                Text(text = "$result is a par number", fontSize = 20.sp)
            } else {
                Text(text = "$result is not a par number", fontSize = 20.sp)
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = returnToStart
            ) {
                Text(text = "Back home", fontSize = 20.sp)
            }
        }
    }
}
