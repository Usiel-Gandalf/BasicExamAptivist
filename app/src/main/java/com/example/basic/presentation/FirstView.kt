package com.example.basic.presentation

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basic.viewModel.FirstViewModel
import com.example.basic.viewModel.ResultViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    navigateToOperatorScreen: (number1: String) -> Unit
) {
    //Variables que van a cambiar su valor segun sea el caso
    var firstValue by remember { mutableStateOf("") }

    //Columna que contiene el boton y el textfield
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp)
    ) {

        Text(text = "Ingresa el primer numero")

        //TextField en donde se captura el primer valor en la primer pantalla
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = firstValue, onValueChange = {
                    firstValue = it
                }, keyboardOptions =
                KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        //Boton para enviar el primer valor a la segunda pantalla
        Button(onClick = {
                navigateToOperatorScreen(firstValue)
        }) {
            Text(text = "Enviar Numero")
        }
    }
}