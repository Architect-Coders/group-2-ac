package com.teamtwo.apilol.sensor

import android.app.Activity
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

class GpsLocation(val context: Context) : LocationListener {

    companion object {
        lateinit var location: Location
    }
    private var locationManager = context.getSystemService(LOCATION_SERVICE) as LocationManager

    init { checkPermission() }

    private fun checkPermission(){

        Dexter.withActivity(context as Activity?)
            .withPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object: PermissionListener{
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {

                    try {
                        locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            0L,
                            0f,
                            this@GpsLocation
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

    override fun onLocationChanged(currentLocation: Location) {
        location = currentLocation
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(provider: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(provider: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}