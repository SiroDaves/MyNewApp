package com.siro.mynewapp.domain

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(
    val context: Context,
): SharedPreferences.OnSharedPreferenceChangeListener{
    override fun onSharedPreferenceChanged(
        p0: SharedPreferences?,
        p1: String?
    ) {
        TODO("Not yet implemented")
    }

}