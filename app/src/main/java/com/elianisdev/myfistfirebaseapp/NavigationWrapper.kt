package com.elianisdev.myfistfirebaseapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elianisdev.myfistfirebaseapp.presentation.initial.InitialScreen
import com.elianisdev.myfistfirebaseapp.presentation.login.LoginScreen
import com.elianisdev.myfistfirebaseapp.presentation.signup.SignupScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = "initial" ) {

        composable("initial") {
            InitialScreen()
        }
        composable("login") {
            LoginScreen()
        }
        composable("signup") {
            SignupScreen()
        }
        
    }

}