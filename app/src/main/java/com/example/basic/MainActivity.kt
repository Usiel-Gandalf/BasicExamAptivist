package com.example.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.basic.navigation.RootNavaGraph
import com.example.basic.presentation.theme.BasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicTheme {
                // A surface container using the 'background' color from the theme
                RootNavaGraph(rememberNavController())
            }
        }
    }
}
