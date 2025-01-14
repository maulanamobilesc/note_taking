package com.maulana.notetaking

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.maulana.notetaking.domain.NoteIntent
import com.maulana.notetaking.ui.component.InputNoteTopBar
import com.maulana.notetaking.ui.component.NoteTopBar
import com.maulana.notetaking.ui.screen.home.HomeScreen
import com.maulana.notetaking.ui.screen.login.LoginScreen
import com.maulana.notetaking.ui.screen.notedetail.NoteDetailScreen
import com.maulana.notetaking.ui.screen.notedetail.NoteDetailViewModel
import com.maulana.notetaking.ui.screen.onboarding.OnBoardingScreen
import com.maulana.notetaking.ui.screen.register.RegisterScreen
import com.maulana.notetaking.ui.screen.sidemenu.SideMenu
import com.maulana.notetaking.ui.theme.Beige
import com.maulana.notetaking.ui.theme.TerraCotta
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteTakingApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val snackBarState = remember { SnackbarHostState() }

    val sheetState = rememberModalBottomSheetState()

    val topAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val keyboardController = LocalSoftwareKeyboardController.current

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    lateinit var noteDetailViewModel: NoteDetailViewModel

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = Beige) {
                SideMenu(navController)
            }
        },
        scrimColor = TerraCotta
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackBarState) },
            topBar = {
                if (backStackEntry?.destination?.route == HomeRoute::class.qualifiedName) {
                    AnimatedVisibility(true) {
                        NoteTopBar(scope,drawerState)
                    }
                } else if (backStackEntry?.destination?.route?.contains(NoteDetailRoute::class.qualifiedName.orEmpty()) == true) {
                    AnimatedVisibility(true) {
                        InputNoteTopBar(onClickLeftAction = {
                            noteDetailViewModel.processIntent(NoteIntent.SaveNote)
                            navController.navigateUp()
                        }, onClickRightAction = {
                            noteDetailViewModel.processIntent(NoteIntent.DeleteNote)
                            navController.navigateUp()
                        }
                        )
                    }
                }
            },
            floatingActionButton = {
                if (backStackEntry?.destination?.route == HomeRoute::class.qualifiedName) {
                    AnimatedVisibility(true) {
                        FloatingActionButton(containerColor = TerraCotta, onClick = {
                            navController.navigate(NoteDetailRoute(""))
                        }) {
                            Icon(Icons.Filled.Add, "Add")
                        }
                    }
                }
            }
        ) { innerPaddings ->
            NavHost(
                navController = navController,
                startDestination = OnBoardingRoute,
                modifier = Modifier.padding(innerPaddings)
            ) {
                composable<OnBoardingRoute> {
                    OnBoardingScreen(navController)
                }

                composable<HomeRoute> {
                    HomeScreen(navController)
                }

                composable<LoginRoute> {
                    LoginScreen(navController)
                }

                composable<RegisterRoute> {
                    RegisterScreen(navController)
                }

                composable<NoteDetailRoute> {
                    noteDetailViewModel = hiltViewModel()
                    val args = it.toRoute<NoteDetailRoute>()
                    NoteDetailScreen(args.id, navController, noteDetailViewModel, snackBarState)
                }
            }
        }
    }

}

@Serializable
object OnBoardingRoute

@Serializable
object HomeRoute

@Serializable
object LoginRoute

@Serializable
object RegisterRoute

@Serializable
object PremiumRoute

@Serializable
data class NoteDetailRoute(
    val id: String
)