package com.mvvm.module.remote.services

import com.google.gson.Gson
import com.mvvm.module.remote.services.intercepter.AuthorizationInterceptor
import okhttp3.Dns
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MovieServiceFactory {

//    inline fun create( okHttpClient: OkHttpClient, baseUrl: String): IMovieServiceApi {
    inline fun <reified T> provideAPIService(okHttpClient: OkHttpClient, baseUrl: String): T {
//        val client = createOkHttp(isDebugMode, apiKey)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return retrofit.create(T::class.java)
    }

    fun createOkHttpClient(isDebugMode: Boolean): OkHttpClient {
        val logging = HttpLoggingInterceptor()

        if (isDebugMode) {
            logging.level =
                HttpLoggingInterceptor.Level.BODY
        } else logging.level = HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .dns(Dns.SYSTEM)
            .connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    fun createOkHttpClientAuthorization(isDebugMode: Boolean, apiKey: String): OkHttpClient {
        val logging = HttpLoggingInterceptor()

        if (isDebugMode) {
            logging.level =
                HttpLoggingInterceptor.Level.BODY
        } else logging.level = HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .dns(Dns.SYSTEM)
            .connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(AuthorizationInterceptor(apiKey))
            .build()
    }

    private const val OK_HTTP_TIMEOUT = 60L
}