package com.teamtwo.apilol.sensor

import android.app.Application
import android.content.Context
import android.location.Geocoder
import android.location.Location

class CountryCode(val application: Application) {

    private var COUNTRY_CODE = "en_US"

    fun getCode(): String {

        var location = GpsLocation.location
        return location?.let {
            getCountryCode(it)
        }?:COUNTRY_CODE

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