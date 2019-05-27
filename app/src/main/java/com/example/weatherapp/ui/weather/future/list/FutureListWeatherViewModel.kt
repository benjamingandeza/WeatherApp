package com.example.weatherapp.ui.weather.future.list

import com.example.weatherapp.provider.UnitProvider
import com.example.weatherapp.repository.ForecastRepository
import com.example.weatherapp.internal.lazyDeferred
import com.example.weatherapp.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}
