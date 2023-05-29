package co.talesbruno.getweatherforecast.data.repository

import co.talesbruno.getweatherforecast.data.api.WeatherApi
import co.talesbruno.getweatherforecast.domain.data.Weather
import co.talesbruno.getweatherforecast.domain.repository.WeatherRepository
import co.talesbruno.getweatherforecast.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi) :
    WeatherRepository {
    override suspend fun getWeather(cityQuery: String): Flow<Result<Weather>> {
        return flow {
            emit(Result.Loading())
            try {
                val response = weatherApi.getWeather(cityQuery)
                if (response.cod == "200") {
                    emit(Result.Success(response))
                } else {
                    emit(Result.Error("Erro na chamada da API: ${response.cod}"))
                }
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }
    }
}
