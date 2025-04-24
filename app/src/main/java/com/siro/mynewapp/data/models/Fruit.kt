package com.siro.mynewapp.data.models

import androidx.annotation.Keep
import androidx.room.*

@Keep
@Entity
data class Fruit(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name="title") val title: String,
    @ColumnInfo(name="description") val description: String,
)
