package com.teamtwo.apilol.sensor

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.location.Location
import android.location.LocationManager
import com.teamtwo.apilol.LolPermission

class GpsLocation(private val context: Application) {

    companion object {
        var location: Location? = null
    }

    init {
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        initLocation(locationManager)
    }

    @SuppressLint("MissingPermission")
    private fun initLocation(locationManager: LocationManager) {

        if(checkPermissionGps())
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
    }

    private fun checkPermissionGps(): Boolean{

        return LolPermission(context)
            .checkPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
    }

}