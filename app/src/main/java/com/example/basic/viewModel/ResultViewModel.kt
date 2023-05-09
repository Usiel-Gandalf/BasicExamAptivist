package com.example.basic.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ResultViewModel: ViewModel(){

    private val _state: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val state: StateFlow<Boolean> = _state

    var result: String by mutableStateOf("")
        private set

     suspend fun makeOperation(firstNumber: String, secondNumber:String, operator: String){

        when(operator){
            "+" ->{
                val myOp = firstNumber.toInt() + secondNumber.toInt()
                result = myOp.toString()
            }
            "-" ->{
                val myOp = firstNumber.toInt() - secondNumber.toInt()
                result = myOp.toString()
            }
            "*" ->{
                val myOp = firstNumber.toInt() * secondNumber.toInt()
                result = myOp.toString()
            }
            "/" ->{
                val myOp = firstNumber.toInt() / secondNumber.toInt()
                result = myOp.toString()
            }
        }

        validatePar(result)
    }

    suspend fun validatePar(result: String) = viewModelScope.launch{
        _state.emit(result.toInt() % 2 == 0)
    }
}