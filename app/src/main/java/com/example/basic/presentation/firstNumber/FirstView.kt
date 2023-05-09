package com.example.basic.presentation.firstNumber

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.basic.presentation.viewModel.ValidationsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    navigateToOperatorScreen: (number1: String) -> Unit,
    viewModel: ValidationsViewModel = viewModel(),
) {
    //This column contain the texfield where we need to put the first Number
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp)
    ) {

        Text(text = "Put the first number")

        //TextField where we put the first number
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = viewModel.valueFromView,
                onValueChange = {
                    viewModel.obtainValueDataFromView(it)
                }, keyboardOptions =
                KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(if (!viewModel.validateIfIsNotEmpty()) "Number is necesary" else "") }
            )
        }

        //Button for send the first value to the second screen
        Button(onClick = {
            if (viewModel.validateIfIsNotEmpty()) {
                navigateToOperatorScreen(viewModel.valueFromView)
            }
        }) {
            Text(text = "Send number", fontSize = 20.sp)
        }
    }
}