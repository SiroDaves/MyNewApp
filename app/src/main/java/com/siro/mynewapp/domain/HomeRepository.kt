package com.siro.mynewapp.domain

import android.content.Context
import android.content.SharedPreferences
import com.siro.mynewapp.data.models.Fruit
import com.siro.mynewapp.data.sources.local.AppDatabase
import com.siro.mynewapp.data.sources.local.FruitsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(
    val context: Context,
) : SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {}

    private var fruitsDao: FruitsDao?

    init {
        val appDb = AppDatabase.getDatabase(context)
        fruitsDao = appDb?.fruitsDao()
    }

    fun fetchAllFruits(): Flow<List<Fruit>> = flow {
        val fruits: List<Fruit>?
        withContext(Dispatchers.IO) {
            fruits = fruitsDao?.getAll()
        }
        emit(fruits!!)
    }

    suspend fun saveFruit(fruit: Fruit){
        withContext(Dispatchers.IO){
            fruitsDao?.insertItem(fruit)
        }
    }
}