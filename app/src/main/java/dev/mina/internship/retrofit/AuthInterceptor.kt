package dev.mina.internship.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest =
            originalRequest.newBuilder().header("Authorization", " Token {YOUR_APP_ID}").build()
        return chain.proceed(newRequest)
    }

}