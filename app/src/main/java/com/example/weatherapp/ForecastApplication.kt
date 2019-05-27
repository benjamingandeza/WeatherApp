package com.example.weatherapp

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import com.example.weatherapp.data.db.ForecastDatabase
import com.example.weatherapp.data.network.*
import com.example.weatherapp.provider.LocationProvider
import com.example.weatherapp.provider.LocationProviderImpl
import com.example.weatherapp.provider.UnitProvider
import com.example.weatherapp.provider.UnitProviderImpl
import com.example.weatherapp.repository.ForecastRepository
import com.example.weatherapp.repository.ForecastRepositoryImpl
import com.example.weatherapp.network.*
import com.example.weatherapp.ui.weather.current.CurrentWeatherViewModelFactory
import com.example.weatherapp.ui.weather.future.detail.FutureDetailWeatherViewModelFactory
import com.example.weatherapp.ui.weather.future.list.FutureListWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*
import org.threeten.bp.LocalDate


class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().futureWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton {
            ConnectivityInterceptorImpl(
                instance()
            )
        }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton {
            WeatherNetworkDataSourceImpl(
                instance()
            )
        }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton {
            LocationProviderImpl(
                instance(),
                instance()
            )
        }
        bind<ForecastRepository>() with singleton {
            ForecastRepositoryImpl(
                instance(),
                instance(),
                instance(),
                instance(),
                instance()
            )
        }
        bind<UnitProvider>() with singleton {
            UnitProviderImpl(
                instance()
            )
        }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
        bind() from provider { FutureListWeatherViewModelFactory(instance(), instance()) }
        bind() from factory { detailDate: LocalDate -> FutureDetailWeatherViewModelFactory(detailDate, instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}