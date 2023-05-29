package co.talesbruno.getweatherforecast.presentation.screens.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import co.talesbruno.getweatherforecast.domain.utils.Result
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.talesbruno.getweatherforecast.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    city: String,
    onNavigateToSearchScreen: () -> Unit
) {
    val weather by mainViewModel.data.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        mainViewModel.getWeather(city)
    }

    when (weather) {
        is Result.Loading -> Column(
            modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            CircularProgressIndicator()
        }
        is Result.Success -> {
            weather.data?.let {
                MainScaffold(
                    weather = it,
                    onNavigateToSearchScreen = onNavigateToSearchScreen
                )
            }
        }
        is Result.Error -> Column(
            modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = weather.message.toString())
        }
    }
}