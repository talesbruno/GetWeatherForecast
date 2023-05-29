package co.talesbruno.getweatherforecast.domain.data

data class WeatherObject(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)