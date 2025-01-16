package com.maulana.notetaking.ui.screen.sidemenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maulana.notetaking.PremiumRoute
import com.maulana.notetaking.R
import com.maulana.notetaking.ui.theme.GlobalDimension
import com.maulana.notetaking.ui.theme.NoteTakingTheme
import com.maulana.warehouse.core.component.Spacer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

val menuList =
    listOf(
        Pair(R.drawable.ic_drawer_premium_3x, "Buy Premium"),
        Pair(
            R.drawable.ic_drawer_edit_3x,
            "Edit Profile"
        ),
        Pair(R.drawable.ic_drawer_theme_3x, "App Theme"),
        Pair(R.drawable.ic_drawer_notif_3x, "Notifications"),
        Pair(R.drawable.ic_drawer_security_3x, "Security"),
        Pair(R.drawable.ic_drawer_logout_3x, "Log Out")
    )

@Composable
fun SideMenu(
    navHostController: NavHostController,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    Column(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "NOTELY", fontSize = GlobalDimension.mainButtonFontSize)
            Spacer(GlobalDimension.sectionPadding)
            Image(
                painter = painterResource(R.drawable.ic_profile_pic_3x),
                contentDescription = "profile picture"
            )
            Spacer(GlobalDimension.sectionPadding)
            Text(text = "User No. 1", fontSize = GlobalDimension.mainTitleFontSize)
            Spacer(GlobalDimension.sectionPadding)
            Text(text = "Bandung, Indonesia", fontSize = GlobalDimension.defaultFontSize)
        }
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = GlobalDimension.mainPadding,
                    vertical = GlobalDimension.largePadding
                ),
            verticalArrangement = Arrangement.spacedBy(GlobalDimension.sectionPadding),
        ) {
            items(items = menuList) { item ->
                Row(Modifier
                    .fillMaxWidth()
                    .clickable {
                        when {
                            item.second.contains("premium", ignoreCase = true) -> {
                                scope.launch {
                                    drawerState.close()
                                }
                                navHostController.navigate(PremiumRoute)
                            }
                        }
                    }, verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(item.first),
                        contentDescription = "left icon"
                    )
                    Spacer(GlobalDimension.smallPadding)
                    Text(
                        text = item.second,
                        fontSize = GlobalDimension.defaultFontSize,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(GlobalDimension.smallPadding)
                    Image(
                        painter = painterResource(R.drawable.ic_arrow_right_3x),
                        contentDescription = "arrow icon"
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SideMenuPreview() {
    NoteTakingTheme {
        SideMenu(
            rememberNavController(),
            rememberDrawerState(DrawerValue.Closed),
            rememberCoroutineScope()
        )
    }
}