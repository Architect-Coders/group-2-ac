package com.teamtwo.apilol.sensor

import android.app.Application
import android.location.Geocoder
import android.location.Location
import com.teamtwo.apilol.Sensor.CountryLanguage

class CountryCode(private val application: Application) {

    companion object {
        private const val COUNTRY_CODE = "en_US"
    }

    fun getCode(): String {
        val location = GpsLocation.location
        return location?.let {
            getCountryCode(it)
        } ?: COUNTRY_CODE
    }

    private fun getCountryCode(location: Location): String{
        val countryData = Geocoder(application)
            .getFromLocation(
                location.latitude,
                location.longitude,
                1)[0]

        return CountryLanguage.valueOf(countryData.countryCode).code
    }
}