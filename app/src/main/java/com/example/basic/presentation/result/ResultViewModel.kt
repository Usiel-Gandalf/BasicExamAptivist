package com.example.basic.presentation.result

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basic.domain.OperationType
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel() {

    private val _state: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val state: StateFlow<Boolean> = _state

    var result: String by mutableStateOf("")
        private set

    suspend fun makeOperation(firstNumber: String, secondNumber: String, operator: OperationType) {
        when (operator) {
            OperationType.ADDITION -> {
                val myOp = firstNumber.toInt() + secondNumber.toInt()
                result = myOp.toString()
            }
            OperationType.SUBTRACTION -> {
                val myOp = firstNumber.toInt() - secondNumber.toInt()
                result = myOp.toString()
            }
            OperationType.DIVISION -> {
                val myOp = firstNumber.toInt() / secondNumber.toInt()
                result = myOp.toString()
            }

            OperationType.MULTIPLICATION ->             {
                val myOp = firstNumber.toInt() * secondNumber.toInt()
                result = myOp.toString()
            }

        }
        validatePar(result)
    }

    suspend fun validatePar(result: String) = viewModelScope.launch {
        _state.emit(result.toInt() % 2 == 0)
    }
}