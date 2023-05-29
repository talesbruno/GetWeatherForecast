package co.talesbruno.getweatherforecast.domain.usecase

import co.talesbruno.getweatherforecast.data.repository.WeatherRepositoryImpl
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val weatherRepositoryImpl: WeatherRepositoryImpl) {
    suspend operator fun invoke(city: String) = weatherRepositoryImpl.getWeather(city)
}