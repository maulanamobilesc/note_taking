package com.maulana.notetaking.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maulana.notetaking.LoginRoute
import com.maulana.notetaking.R
import com.maulana.notetaking.RegisterRoute
import com.maulana.notetaking.ui.component.PrimaryButton
import com.maulana.notetaking.ui.theme.GlobalDimension
import com.maulana.notetaking.ui.theme.NoteTakingTheme
import com.maulana.notetaking.ui.theme.TerraCotta
import com.maulana.notetaking.util.noRippleClickable
import com.maulana.warehouse.core.component.Spacer

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(GlobalDimension.mainPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(GlobalDimension.sectionPadding)
        Text(text = "NOTELY", fontSize = GlobalDimension.mainButtonFontSize)
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_note_onboarding_3x),
                contentDescription = "note onboarding"
            )
            Spacer(GlobalDimension.componentPadding)
            Text(
                text = "World's Safest And Largest Digital Notebook",
                textAlign = TextAlign.Center,
                fontSize = GlobalDimension.titleFontSize,
                style = TextStyle(fontWeight = FontWeight.Black)
            )
            Spacer(GlobalDimension.componentPadding)
            Text(
                text = "Notely is the world's safest, largest and intelligent digital notebook. Join over 10M+ users already using Notely.",
                textAlign = TextAlign.Center,
                fontSize = GlobalDimension.defaultFontSize,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = GlobalDimension.sectionPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryButton(onClick = { navController.navigate(RegisterRoute) }, text = "GET STARTED")
            Spacer(GlobalDimension.componentPadding)
            Text(
                "Already have an account?",
                fontSize = GlobalDimension.defaultFontSize,
                style = TextStyle(fontWeight = FontWeight.ExtraBold),
                color = TerraCotta,
                modifier = Modifier.noRippleClickable {
                    navController.navigate(LoginRoute)
                }
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun OnBoardingScreenPreview() {
    NoteTakingTheme(dynamicColor = false) {
        OnBoardingScreen(rememberNavController())
    }
}