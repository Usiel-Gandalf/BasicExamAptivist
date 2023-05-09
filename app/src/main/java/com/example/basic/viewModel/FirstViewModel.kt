package com.example.basic.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FirstViewModel: ViewModel() {

    private val _state: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val state: StateFlow<Boolean> = _state

    suspend fun validateIfIsNumber(value: String) = viewModelScope.launch {
        val parseNumber: Int? = value.toIntOrNull()
        if (parseNumber != null){
            _state.emit(true)
        }else{
            _state.emit(false)
        }
    }
}