package com.example.weatherapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Typeface
import android.widget.ProgressBar
import android.widget.TextView



class WeatherReadings : AppCompatActivity() {


    var selectCity: TextView? = null
    var cityField:TextView? = null
    var detailsField:TextView? = null
    var currentTemperatureField:TextView? = null
    var humidity_field:TextView? = null
    var pressure_field:TextView? = null
    var weatherIcon:TextView? = null
    var updatedField:TextView? = null
    var loader: ProgressBar? = null
    var weatherFont: Typeface? = null

    var OPEN_WEATHER_MAP_API = "9b6ff88cbef9de15b70cf2084a747ac0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.readings_weather)

        supportActionBar?.hide()


    }
}
