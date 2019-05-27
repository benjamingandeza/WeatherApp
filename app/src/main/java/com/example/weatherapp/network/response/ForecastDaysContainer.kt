package com.example.weatherapp.network.response

import com.google.gson.annotations.SerializedName
import com.example.weatherapp.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)