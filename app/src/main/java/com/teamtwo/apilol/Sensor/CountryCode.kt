package com.teamtwo.apilol.Sensor

import android.content.Context
import android.location.Geocoder
import android.location.Location

class CountryCode(val location: Location, val context: Context) {

    fun getCode(): String{
        val countryData = Geocoder(context)
                .getFromLocation(
                    location.latitude,
                    location.longitude,
                    1)[0]

        return CountryLanguage.valueOf(countryData.countryCode).code
    }
}