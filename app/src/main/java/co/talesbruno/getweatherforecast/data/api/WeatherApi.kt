package co.talesbruno.getweatherforecast.data.api

import co.talesbruno.getweatherforecast.domain.data.Weather
import co.talesbruno.getweatherforecast.domain.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(value = "data/2.5/forecast/daily/")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = Constants.API_KEY
    ) : Weather
}