package com.elianisdev.myfistfirebaseapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elianisdev.myfistfirebaseapp.presentation.home.HomeScreen
import com.elianisdev.myfistfirebaseapp.presentation.initial.InitialScreen
import com.elianisdev.myfistfirebaseapp.presentation.login.LoginScreen
import com.elianisdev.myfistfirebaseapp.presentation.signup.SignupScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth) {

    NavHost(navController = navHostController, startDestination = "initial" ) {

        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHostController.navigate("logIn") },
                navigateToSignUp = { navHostController.navigate("signUp") }
            )
        }
        composable("logIn") {
            LoginScreen(
                auth,
                navigateToHome = { navHostController.navigate("home") }
            )
        }
        composable("signUp") {
            SignupScreen(auth)
        }
        composable("home") {
            HomeScreen(
                auth,
                navigateBackToInitial = { navHostController.navigate("initial") }
            )
        }
        
    }

}