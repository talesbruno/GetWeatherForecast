package co.talesbruno.getweatherforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import co.talesbruno.getweatherforecast.presentation.navigation.WeatherNavigation
import co.talesbruno.getweatherforecast.presentation.viewmodel.MainViewModel
import co.talesbruno.getweatherforecast.ui.theme.GetWeatherForecastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            WeatherApp(mainViewModel)
        }
    }
}

@Composable
fun WeatherApp(
    mainViewModel: MainViewModel
) {
    GetWeatherForecastTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WeatherNavigation(mainViewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetWeatherForecastTheme() {

    }
}