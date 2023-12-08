package com.example.cs3200firebasestarter.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.cs3200firebasestarter.ui.components.CreateFlashcardScreen
import com.example.cs3200firebasestarter.ui.repositories.UserRepository
import com.example.cs3200firebasestarter.ui.screens.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    LaunchedEffect(true) {

    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Logout") },
                    selected = false,
                    onClick = {
                        UserRepository.logout()
                        navController.navigate(Routes.launchNavigation.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                    }
                )
                // ...other drawer items
            }
        }
    ) {
        Scaffold(
            topBar = {
                if (currentDestination?.hierarchy?.none { it.route == Routes.launchNavigation.route || it.route == Routes.splashScreen.route } == true) {
                    TopAppBar(
                        title = { Text(text = "Flashcards")},
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }) {
                                Icon(Icons.Default.Menu, contentDescription = "Menu button")
                            }
                        }
                    )
                }
            },


        ) {

            NavHost(
                navController = navController,
                startDestination = Routes.splashScreen.route,
                modifier = Modifier.padding(paddingValues = it)
            ) {
                navigation(route = Routes.launchNavigation.route, startDestination = Routes.launch.route) {
                    composable(route = Routes.launch.route) { LaunchScreen(navController) }
                    composable(route = Routes.signIn.route) { SignInScreen(navController) }
                    composable(route = Routes.signUp.route) { SignUpScreen(navController) }
                    composable(route = Routes.createSet.route) { CreateSetScreen(navController) }
                    composable(
                        route = "flashCardScreen?id={id}",
                        arguments = listOf(navArgument("id"){defaultValue = "new"})
                    ) {navBackStackEntry ->
                        FlashCardScreen(navController, navBackStackEntry.arguments?.get("id").toString())
                    }
                    composable(
                        route = "createFlashCardScreen?id={id}",
                        arguments = listOf(navArgument("id"){defaultValue = "new"})
                    ) {navBackStackEntry ->
                        CreateFlashcardScreen(navController, navBackStackEntry.arguments?.get("id").toString())
                    }                }
                navigation(route = Routes.appNavigation.route, startDestination = Routes.home.route) {
                    composable(route = Routes.home.route) { HomeScreen(navController) }
                }
                composable(route = Routes.splashScreen.route) { SplashScreen(navController) }
            }
        }
    }
}