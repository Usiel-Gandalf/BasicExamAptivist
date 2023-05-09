package com.example.basic.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ValidationsViewModel : ViewModel() {


    var valueFromView: String by mutableStateOf("")
        private set

    fun obtainValueDataFromView(value: String) {
        valueFromView = value
    }

    fun validateIfIsNotEmpty(): Boolean {
        return valueFromView.isNotEmpty()
    }
}