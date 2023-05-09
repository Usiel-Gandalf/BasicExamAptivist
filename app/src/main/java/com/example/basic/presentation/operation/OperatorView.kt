package com.example.basic.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basic.domain.OperationType

@Composable
fun OperatorView(
    firstValue: String,
    navigateToSecondView: (value1: String, operator: OperationType) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 50.dp, top = 50.dp)
    ) {

        Text(text = "Selecciona el operador", fontSize = 20.sp)

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)) {
            Button(modifier = Modifier.padding(start = 20.dp),onClick = {
                navigateToSecondView(firstValue, OperationType.ADDITION)
            }) {
                Text(text = "+")
            }

            Button(onClick = {
                navigateToSecondView(firstValue, OperationType.SUBTRACTION)
            }) {
                Text(text = "-")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)) {
            Button(modifier = Modifier.padding(start = 20.dp), onClick = {
                navigateToSecondView(firstValue, OperationType.MULTIPLICATION)
            }) {
                Text(text = "*")
            }

            Button(onClick = {
                navigateToSecondView(firstValue, OperationType.DIVISION)
            }) {
                Text(text = "/")
            }
        }
    }
}

