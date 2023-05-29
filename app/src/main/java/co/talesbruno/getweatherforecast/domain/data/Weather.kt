package co.talesbruno.getweatherforecast.domain.data

data class Weather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherItem>,
    val message: Double
)