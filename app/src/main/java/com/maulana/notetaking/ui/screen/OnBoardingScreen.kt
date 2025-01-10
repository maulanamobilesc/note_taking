package com.maulana.notetaking.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maulana.notetaking.LoginRoute
import com.maulana.notetaking.ui.component.PrimaryButton
import com.maulana.notetaking.ui.theme.GlobalDimension
import com.maulana.notetaking.ui.theme.NoteTakingTheme

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(GlobalDimension.mainPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "NOTELY")
        Text(text = "World's Safest And Largest Digital Notebook")
        Text(text = "Notely is the world's safest, largest and intelligent digital notebook. Join over 10M+ users already using Notely.")
        PrimaryButton(onClick = { navController.navigate(LoginRoute) }, text = "GET STARTED")
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun OnBoardingScreenPreview() {
    NoteTakingTheme(dynamicColor = false) {
        OnBoardingScreen(rememberNavController())
    }
}