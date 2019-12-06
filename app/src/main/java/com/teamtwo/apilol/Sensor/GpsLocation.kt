package com.teamtwo.apilol.Sensor

import android.icu.util.ULocale
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.teamtwo.apilol.R
import com.teamtwo.apilol.toast
import java.util.*


class GpsLocation : AppCompatActivity() {

    companion object {
        var currentLocationcode: String = "en_US"
    }

    private var locationManager : LocationManager? = null

    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {

            val newLocation: String = getLocationCode(location)
            locationSave(newLocation)
        }
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

     fun initGps() {

        locationManager = baseContext.getSystemService(LOCATION_SERVICE) as LocationManager?
        checkPermission()
    }

    private fun checkPermission(){

        Dexter.withActivity(this)
            .withPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object: PermissionListener{
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {

                    try {
                        locationManager?.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            0L,
                            0f,
                            locationListener
                        )
                    } catch(ex: SecurityException) {

                    }
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?) {

                    token?.continuePermissionRequest()
                }
            }).check()
    }

    private fun getLocationCode(location: Location): String{

        var countryCode = getCountryCode(location)
        var languageCode = getLanguageCode(countryCode)

        return "${languageCode}_${countryCode}"
    }

    private fun getCountryCode(location: Location): String{

        return Geocoder(this)
            .getFromLocation(
                location.latitude,
                location.longitude,
                1)[0]
            .countryCode
    }

    private fun getLanguageCode(countryCode: String): String{

        return CountryLanguage.valueOf(countryCode).code
    }

    private fun locationSave(location:String){
        currentLocationcode = location
    }
}