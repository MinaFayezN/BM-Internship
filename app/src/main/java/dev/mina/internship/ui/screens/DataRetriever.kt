package dev.mina.internship.ui.screens

import dev.mina.internship.ui.database.Profile
import dev.mina.internship.ui.database.ProfileDatabase


fun getAllProfilesFromDatabase(database: ProfileDatabase): List<Profile> {
    val profileDao = database.retrieveProfileDao()
    return profileDao.getAllProfiles()
}

fun getProfileFromDatabase(database: ProfileDatabase,id:Int):Profile {
    val profileDao = database.retrieveProfileDao()
    return profileDao.getProfile(id)
}


fun saveProfileToDatabase(database: ProfileDatabase, profile: Profile) {
    val profileDao = database.retrieveProfileDao()
    profileDao.insertProfile(profile)
}

fun updateProfileInDatabase(database: ProfileDatabase, profile: Profile) {
    val profileDao = database.retrieveProfileDao()
    profileDao.updateProfile(profile)
}

fun deleteProfileFromDatabase(database: ProfileDatabase, profile: Profile) {
    val profileDao = database.retrieveProfileDao()
    profileDao.deleteProfile(profile)
}
