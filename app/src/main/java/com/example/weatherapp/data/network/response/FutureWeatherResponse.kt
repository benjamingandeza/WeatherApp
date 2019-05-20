package com.example.weatherapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.example.weatherapp.data.db.entity.WeatherLocation
import com.example.weatherapp.data.network.response.ForecastDaysContainer

data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)