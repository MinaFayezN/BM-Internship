package dev.mina.internship.retrofit

import dev.mina.internship.ContactsAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private val httpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()
    private val logger = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://mocki.io/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .client(logger)
        .build()

    fun retrieveContactService(): ContactsAPI {
        return retrofit.create(ContactsAPI::class.java)
    }
}