package com.maulana.notetaking.ui.screen.premium

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
import com.maulana.notetaking.HomeRoute
import com.maulana.notetaking.LoginRoute
import com.maulana.notetaking.R
import com.maulana.notetaking.ui.component.PrimaryButton
import com.maulana.notetaking.ui.theme.GlobalDimension
import com.maulana.notetaking.ui.theme.NoteTakingTheme
import com.maulana.notetaking.ui.theme.TerraCotta
import com.maulana.notetaking.util.noRippleClickable
import com.maulana.warehouse.core.component.Spacer

@Composable
fun PremiumScreen(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(GlobalDimension.mainPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(GlobalDimension.sectionPadding)
        Text(text = "Notely Premium", fontSize = GlobalDimension.mainButtonFontSize)
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_note_premium_3x),
                contentDescription = "note premium"
            )
            Spacer(GlobalDimension.componentPadding)
            Text(
                text = "Start Using Notely with Premium Benefits",
                textAlign = TextAlign.Center,
                fontSize = GlobalDimension.titleFontSize,
                style = TextStyle(fontWeight = FontWeight.Black)
            )
            Spacer(GlobalDimension.componentPadding)
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.ic_check_3x), "check 1")
                Spacer(GlobalDimension.smallPadding)
                Text(
                    text = "Save unlimited notes to a single project",
                    textAlign = TextAlign.Center,
                    fontSize = GlobalDimension.defaultFontSize,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
            Spacer(GlobalDimension.smallPadding)
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.ic_check_3x), "check 2")
                Spacer(GlobalDimension.smallPadding)
                Text(
                    text = "Create unlimited projects and teams",
                    textAlign = TextAlign.Center,
                    fontSize = GlobalDimension.defaultFontSize,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
            Spacer(GlobalDimension.smallPadding)
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.ic_check_3x), "check 3")
                Spacer(GlobalDimension.smallPadding)
                Text(
                    text = "Daily backups to keep your data safe",
                    textAlign = TextAlign.Center,
                    fontSize = GlobalDimension.defaultFontSize,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
            Spacer(GlobalDimension.sectionPadding)
            Row(
                Modifier.fillMaxWidth(),
            ) {
                Card(
                    Modifier
                        .fillMaxWidth(0.5f)
                        .padding(end = GlobalDimension.smallPadding)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(GlobalDimension.componentPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Annual",
                            textAlign = TextAlign.Center,
                            fontSize = GlobalDimension.defaultFontSize,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Spacer(GlobalDimension.smallPadding)
                        Text(
                            text = "$79.99",
                            textAlign = TextAlign.Center,
                            fontSize = GlobalDimension.defaultFontSize,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Spacer(GlobalDimension.smallPadding)
                        Text(
                            text = "per year",
                            textAlign = TextAlign.Center,
                            fontSize = GlobalDimension.defaultFontSize,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                    }
                }
                Card(
                    Modifier
                        .fillMaxWidth(1f)
                        .padding(start = GlobalDimension.smallPadding)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(GlobalDimension.componentPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Monthly",
                            textAlign = TextAlign.Center,
                            fontSize = GlobalDimension.defaultFontSize,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Spacer(GlobalDimension.smallPadding)
                        Text(
                            text = "$7.99",
                            textAlign = TextAlign.Center,
                            fontSize = GlobalDimension.defaultFontSize,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Spacer(GlobalDimension.smallPadding)
                        Text(
                            text = "per month",
                            textAlign = TextAlign.Center,
                            fontSize = GlobalDimension.defaultFontSize,
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = GlobalDimension.sectionPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryButton(onClick = { navController.navigate(HomeRoute) }, text = "SUBSCRIBE")
            Spacer(GlobalDimension.componentPadding)
            Text(
                "Restore Purchase",
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
fun PremiumScreenPreview() {
    NoteTakingTheme(dynamicColor = false) {
        PremiumScreen(rememberNavController())
    }
}