package com.givekesh.movies.utils

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url
        val requestBuilder = original.newBuilder()
            .addHeader("Authorization", "Bearer ${Constants.TMDB_TOKEN}")
            .url(originalHttpUrl)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}