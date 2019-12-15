package com.teamtwo.apilol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

fun Context.toast(message: String, lenght: Int = android.widget.Toast.LENGTH_LONG){
    Toast.makeText(this, message, lenght).show()
}

fun RecyclerView.ViewHolder.toast(message: String, lenght: Int = Toast.LENGTH_LONG) {
    itemView.context.toast(message, lenght)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadUrl(url: String) {
    Picasso.get().load(url).into(this)
}