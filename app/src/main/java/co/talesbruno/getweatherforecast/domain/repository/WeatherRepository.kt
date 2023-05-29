package co.talesbruno.getweatherforecast.domain.repository

import co.talesbruno.getweatherforecast.domain.data.Weather
import co.talesbruno.getweatherforecast.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(cityQuery: String) : Flow<Result<Weather>>
}