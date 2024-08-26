package com.elianisdev.myfistfirebaseapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.elianisdev.myfistfirebaseapp.ui.theme.MyfistFirebaseAppTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class
MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        enableEdgeToEdge()
        setContent {
            navHostController = rememberNavController()
            MyfistFirebaseAppTheme {
               Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                     NavigationWrapper( navHostController, auth)
               }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null) {
            Log.i("MainActivity", "User is already logged in")
        }
    }
}

