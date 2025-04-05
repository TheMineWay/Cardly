package org.themineway.cardly.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.themineway.cardly.navigation.screens.CardScreen
import org.themineway.cardly.navigation.screens.HomeScreen

@Composable
fun Router(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding()
    ) {
        composable<HomeRoute> {
            HomeScreen(navigateToTestCard = {
                navController.navigate(CardRoute("test_id"));
            });
        }
        composable<CardRoute> { backStackEntry ->
            var cardRoute: CardRoute = backStackEntry.toRoute();
            CardScreen(cardRoute.id);
        }
    }
}