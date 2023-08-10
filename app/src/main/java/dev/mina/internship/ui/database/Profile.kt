package dev.mina.internship.ui.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val age: Int,
)
