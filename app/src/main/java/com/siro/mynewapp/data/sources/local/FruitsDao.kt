package com.siro.mynewapp.data.sources.local

import androidx.room.*
import com.siro.mynewapp.data.models.Fruit

@Dao
interface FruitsDao {
    @Query("SELECT * FROM fruit")
    fun getAll(): List<Fruit>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertItem(item: Fruit)
}