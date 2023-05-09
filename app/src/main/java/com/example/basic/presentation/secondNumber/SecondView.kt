package com.example.basic.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basic.domain.OperationType
import com.example.basic.presentation.viewModel.ValidationsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondView(
    fistValue: String,
    operaton: OperationType,
    viewModel: ValidationsViewModel = viewModel(),
    navigateToResult: (fistValue: String, operator: OperationType, secondValue: String) -> Unit,
) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, top = 20.dp)){
        Text(text = "Put the second number")

        Column(modifier = Modifier.fillMaxWidth() ){
            TextField(
                value = viewModel.valueFromView,
                onValueChange = {
                    viewModel.obtainValueDataFromView(it)
                }, keyboardOptions =
                KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text( if (!viewModel.validateIfIsNotEmpty()) "Number is necessary" else "") }
            )
        }

        Button(onClick = {
            navigateToResult(fistValue, operaton, viewModel.valueFromView)
        }) {
            Text(text = "Send number", fontSize = 20.sp)
        }
    }
}