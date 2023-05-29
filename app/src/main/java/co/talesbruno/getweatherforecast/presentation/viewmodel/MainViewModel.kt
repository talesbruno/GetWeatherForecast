package co.talesbruno.getweatherforecast.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.talesbruno.getweatherforecast.domain.data.Weather
import co.talesbruno.getweatherforecast.domain.usecase.GetWeatherUseCase
import co.talesbruno.getweatherforecast.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getWeatherUseCase: GetWeatherUseCase) :
    ViewModel() {
    private val _data =
        MutableStateFlow<Result<Weather>>(Result.Loading())
    val data: StateFlow<Result<Weather>> = _data

    fun getWeather(city: String) {
        viewModelScope.launch {
            getWeatherUseCase(city).collect {
                _data.value = it
            }
        }
    }
}