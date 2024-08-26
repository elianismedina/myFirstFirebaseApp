package com.elianisdev.myfistfirebaseapp.presentation.home


import android.R.drawable.ic_menu_more
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.elianisdev.myfistfirebaseapp.ui.theme.Black

import com.google.firebase.auth.FirebaseAuth



@Composable
fun ScaffoldExample(
    auth: FirebaseAuth,
    navigateBackToInitial: () -> Unit
){
    Scaffold(
        topBar ={
            Text(text = "Top Bar",
            color = Color.White
            )
        },
        bottomBar = {
            Text(text = "Bottom Bar",
                color = Color.White
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = ic_menu_more), contentDescription = null)

            }
        }



    ) {
        innerPadding ->
        HomeScreen(auth = FirebaseAuth.getInstance(),
            navigateBackToInitial = navigateBackToInitial,
        modifier = Modifier.padding(innerPadding)
        )


    }
}
@Composable
fun HomeScreen(auth: FirebaseAuth, navigateBackToInitial: () -> Unit = {} , modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Icon(painter = painterResource(id = ic_menu_more),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

        }

        Text(text = "Home", color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Button(onClick = {
            auth.signOut()
            Log.i("HomeScreen", "User is logged out")
            navigateBackToInitial()
        }){
            Text(text = "Log Out", color = Color.White)

        }



    }

}
