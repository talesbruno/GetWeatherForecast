package co.talesbruno.getweatherforecast.presentation.screens.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import co.talesbruno.getweatherforecast.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.talesbruno.getweatherforecast.domain.data.Weather
import co.talesbruno.getweatherforecast.domain.data.WeatherItem
import co.talesbruno.getweatherforecast.domain.utils.convertIcon
import co.talesbruno.getweatherforecast.domain.utils.convertUnixToDate
import co.talesbruno.getweatherforecast.domain.utils.formatNumber
import co.talesbruno.getweatherforecast.ui.theme.GetWeatherForecastTheme
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    weather: Weather,
    onNavigateToSearchScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home", color = MaterialTheme.colorScheme.onPrimary)
                },
                actions = {
                    IconButton(
                        onClick = { onNavigateToSearchScreen() },
                        colors = IconButtonDefaults.iconButtonColors(contentColor = MaterialTheme.colorScheme.onPrimary)
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherTempContent(
                    city = weather.city.name,
                    temp = weather.list[0].temp.day,
                    maxTemp = weather.list[0].temp.max,
                    minTemp = weather.list[0].temp.min,
                    weather = weather.list[0].weather[0].main,
                    icon = weather.list[0].weather[0].icon
                )
                Divider()
                WeatherHumidityWindRow(
                    wind = weather.list[0].speed,
                    humidity = weather.list[0].humidity,
                )
                Divider()
                WeeklyForecast(
                    weather = weather
                )
            }
        }
    )
}

@Composable
fun WeatherTempContent(
    city: String,
    temp: Double,
    maxTemp: Double,
    minTemp: Double,
    weather: String,
    icon: String
) {
    Card(
        modifier = Modifier
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = city,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "${formatNumber(temp)}°",
                fontSize = 76.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Image(
                painter = painterResource(convertIcon(icon)),
                contentDescription = null,
                modifier = Modifier.size(45.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
            Text(
                text = weather,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Row() {
                Text(
                    text = "${formatNumber(maxTemp)}°",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "${formatNumber(minTemp)}°",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }

}


@Composable
fun WeatherHumidityWindRow(
    wind: Double,
    humidity: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ativo8),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
            Text(
                text = "$humidity%",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ativo12),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
            Text(
                text = "${formatNumber(wind)} Km/h",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun WeeklyForecast(weather: Weather) {
    LazyRow() {
        items(items = weather.list) {
            WeekItem(it)
        }
    }
}

@Composable
fun WeekItem(weatherItem: WeatherItem) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(80.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = convertUnixToDate(weatherItem.dt.toLong()),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Image(
                painter = painterResource(convertIcon(weatherItem.weather[0].icon)),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
            Text(
                text = "Max",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "${formatNumber(weatherItem.temp.max)}°",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "Min",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "${formatNumber(weatherItem.temp.min)}°",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun WeatherImage(imageUrl: String) {
    Card() {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetWeatherForecastTheme {
        WeatherTempContent(
            city = "Porteirinha",
            temp = 10.0,
            maxTemp = 20.0,
            minTemp = 10.0,
            weather = "Nublado",
            icon = ""
        )
    }
}