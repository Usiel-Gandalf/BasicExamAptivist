package com.example.basic.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OperatorView(
    firstValue: String,
    navigateToSecondView: (value1: String, operator: String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 20.dp)
    ) {

        Text(text = "Selecciona el operador")

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                navigateToSecondView(firstValue, "+")
            }) {
                Text(text = "+")
            }

            Button(onClick = {
                navigateToSecondView(firstValue, "-")
            }) {
                Text(text = "-")
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                navigateToSecondView(firstValue, "*")
            }) {
                Text(text = "*")
            }

            Button(onClick = {
                navigateToSecondView(firstValue, "/")
            }) {
                Text(text = "/")
            }
        }
    }
}

