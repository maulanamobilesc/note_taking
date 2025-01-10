package com.maulana.notetaking.ui.screen.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maulana.notetaking.ui.component.PasswordField
import com.maulana.notetaking.ui.component.PlainTextField
import com.maulana.notetaking.ui.component.PrimaryButton
import com.maulana.notetaking.ui.theme.GlobalDimension
import com.maulana.notetaking.ui.theme.NoteTakingTheme
import com.maulana.notetaking.ui.theme.TerraCotta
import com.maulana.warehouse.core.component.Spacer

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    RegisterContent(navHostController)
}

@Composable
fun RegisterContent(navHostController: NavHostController) {
    val focusManager = LocalFocusManager.current

    Column(
        Modifier
            .fillMaxWidth()
            .padding(GlobalDimension.mainPadding)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Create a free account", fontSize = GlobalDimension.titleFontSize,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Spacer(GlobalDimension.smallPadding)
            Text(
                "Join Notely for free. Create and share unlimited notes with your friends.",
                textAlign = TextAlign.Center,
                fontSize = GlobalDimension.defaultFontSize,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .weight(2f)
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Full Name")
            Spacer(GlobalDimension.smallPadding)
            PlainTextField("") { }
            Spacer(GlobalDimension.componentPadding)
            Text("Email Address")
            Spacer(GlobalDimension.smallPadding)
            PlainTextField("") { }
            Spacer(GlobalDimension.componentPadding)
            Text("Password")
            Spacer(GlobalDimension.smallPadding)
            PasswordField("", focusManager) { }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            PrimaryButton("Create Account") {
                //navHostController.navigate(NoteDestination.route)
            }
            Spacer(GlobalDimension.componentPadding)
            Text(
                "Already have an account?",
                fontSize = GlobalDimension.defaultFontSize,
                style = TextStyle(fontWeight = FontWeight.ExtraBold),
                color = TerraCotta,
            )
        }
    }
}

@Preview(showSystemUi = true, device = "id:pixel_8", backgroundColor = 0xFFF8EEE2)
@Composable
fun PreviewRegistration() {
    NoteTakingTheme(dynamicColor = false) {
        RegisterContent(rememberNavController())
    }
}