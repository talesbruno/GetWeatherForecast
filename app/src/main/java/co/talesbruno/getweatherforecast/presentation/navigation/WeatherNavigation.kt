package co.talesbruno.getweatherforecast.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.talesbruno.getweatherforecast.presentation.screens.mainscreen.MainScreen
import co.talesbruno.getweatherforecast.presentation.screens.searchscreen.SearchScreen
import co.talesbruno.getweatherforecast.presentation.viewmodel.MainViewModel

@Composable
fun WeatherNavigation(
    mainViewModel: MainViewModel
) {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = WeatherScreens.SearchScreen.route) {
        composable(
            route = WeatherScreens.MainScreen.route,
            arguments = listOf(navArgument("city") { type = NavType.StringType })
        ) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city")
            requireNotNull(city)
            MainScreen(
                mainViewModel = mainViewModel,
                city = city,
                onNavigateToSearchScreen = {
                    navHostController.navigate(WeatherScreens.SearchScreen.route)
                }
            )
        }
        composable(
            route = WeatherScreens.SearchScreen.route
        ) {
            SearchScreen(
                onNavigateToMainScreen = { city ->
                    navHostController.navigate(WeatherScreens.MainScreen.createRoute(city))
                },
                popBackStack = {
                    navHostController.popBackStack()
                },
            )
        }
    }
}