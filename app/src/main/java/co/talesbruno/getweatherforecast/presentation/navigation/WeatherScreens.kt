package co.talesbruno.getweatherforecast.presentation.navigation

sealed class WeatherScreens(val route: String) {
    object MainScreen : WeatherScreens("mainscreen/{city}"){
        fun createRoute(city: String) = "mainscreen/$city"
    }
    object SearchScreen : WeatherScreens("searchscreen")
}
