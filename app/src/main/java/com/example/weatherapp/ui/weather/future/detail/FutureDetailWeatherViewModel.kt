package com.example.weatherapp.ui.weather.future.detail

import com.example.weatherapp.provider.UnitProvider
import com.example.weatherapp.repository.ForecastRepository
import com.example.weatherapp.internal.lazyDeferred
import com.example.weatherapp.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
