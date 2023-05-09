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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondView(
    fistValue: String,
    operaton: String,
    navigateToResult: (fistValue: String, operator: String, secondValue: String) -> Unit,
) {
    var secondValue by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, top = 20.dp)){
        Text(text = "Ingresa el segundo numero")

        Column(modifier = Modifier.fillMaxWidth() ){
            TextField(
                value = secondValue, onValueChange = {
                    secondValue = it
                }, keyboardOptions =
                KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Button(onClick = {
            navigateToResult(fistValue, operaton, secondValue)
        }) {
            Text(text = "Enviar")
        }
    }
}