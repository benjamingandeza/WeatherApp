package com.example.weatherapp.provider

import com.example.weatherapp.internal.UnitSystem


interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}