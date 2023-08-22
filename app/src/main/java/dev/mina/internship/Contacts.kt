package dev.mina.internship

import com.google.gson.annotations.SerializedName

data class Contacts(
    val contacts: List<Contact>,
)

data class Contact(
    @SerializedName("id")
    val contactID: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("company")
    val companyName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("photo")
    val photo: String,
)
