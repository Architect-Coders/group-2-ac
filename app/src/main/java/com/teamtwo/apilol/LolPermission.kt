package com.teamtwo.apilol

import android.Manifest
import android.app.Activity
import android.app.Application
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.teamtwo.apilol.Sensor.GpsLocation

class LolPermission(private val context: Application) {

    fun checkPermission(permission: String):Boolean{

        val permission = ContextCompat
                .checkSelfPermission(
                    context,
                    permission
                )

        return permission == PackageManager.PERMISSION_GRANTED
    }
}