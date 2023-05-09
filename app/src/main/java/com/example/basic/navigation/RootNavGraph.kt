package com.example.basic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.basic.presentation.FirstScreen
import com.example.basic.presentation.OperatorView
import com.example.basic.presentation.ResultView
import com.example.basic.presentation.SecondView

@Composable
fun RootNavaGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = NavigationScreen.FirstScreen.route)
    {
        composable(NavigationScreen.FirstScreen.route){
            FirstScreen(navigateToOperatorScreen = {
                    navController.navigate(NavigationScreen.OperatorScreen.route + "/${it}")
            })
        }

        composable(NavigationScreen.OperatorScreen.route + "/{value1}"){
            val number1 = it.arguments?.getString("value1") ?: "You must pass some value"
            OperatorView(firstValue = number1, navigateToSecondView = { firstValue, operator ->
                navController.navigate(NavigationScreen.SecondScreen.route + "/${firstValue}" + "/${operator}")
            })
        }

        composable(NavigationScreen.SecondScreen.route + "/{value1}" + "/{operator}"){
            val number1 = it.arguments?.getString("value1") ?: "You must to do something"
            val operator = it.arguments?.getString("operator") ?: "Yo must"

            SecondView(fistValue = number1, operaton = operator, navigateToResult = { firstValue, operator, secondValue ->
                navController.navigate(NavigationScreen.ResultScreen.route + "/${firstValue}" + "/${operator}" + "/${secondValue}")
            })
        }
        
        composable(NavigationScreen.ResultScreen.route + "/{value1}" + "/{operator}" + "/{value2}"){
            val number1 = it.arguments?.getString("value1") ?: "You must to do something"
            val operator = it.arguments?.getString("operator") ?: "Yo must"
            val number2 = it.arguments?.getString("value2") ?: "You must to do something"
            ResultView(firstValue = number1, operator = operator, secondValue = number2, returnToStart = {
                navController.navigate(NavigationScreen.FirstScreen.route){
                    popUpTo(NavigationScreen.FirstScreen.route){
                        inclusive = true
                    }
                }
            })
        }
    }
}

sealed class NavigationScreen(val route: String) {
    object FirstScreen : NavigationScreen(route = "FIRST_SCREEN")
    object OperatorScreen : NavigationScreen(route = "OPERATOR_SCREEN")
    object SecondScreen : NavigationScreen(route = "SECOND_SCREEN")
    object ResultScreen : NavigationScreen(route = "RESULT_SCREEN")
}