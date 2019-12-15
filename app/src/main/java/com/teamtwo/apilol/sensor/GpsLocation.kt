package com.teamtwo.apilol.sensor

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.teamtwo.apilol.LolPermission

class GpsLocation(private val context: Application) {

    companion object {
        var location: Location? = null
    }

    init {
        var locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
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