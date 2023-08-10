package dev.mina.internship.ui.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ProfileDao {

    @Insert
    fun insertProfile(profile: Profile)

    @Update
    fun updateProfile(profile: Profile)

    @Delete
    fun deleteProfile(profile: Profile)

    @Query("SELECT * FROM profile")
    fun getAllProfiles(): List<Profile>

    @Query("SELECT * FROM profile WHERE id = :id")
    fun getProfile(id:Int): Profile
}