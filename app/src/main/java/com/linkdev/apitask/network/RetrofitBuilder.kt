package com.linkdev.apitask.network

import com.linkdev.apitask.network.NetworkConstants.TIME_60
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS

class RetrofitBuilder {

    companion object {

        fun getAPIService(): Api {

            val retrofit = Retrofit.Builder()
                .baseUrl(NetworkConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOKHTTPClient())
                .build()

            val api = retrofit.create(Api::class.java)

            return api
        }

        private fun createOKHTTPClient(): OkHttpClient {

            val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(BODY)

            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(TIME_60, SECONDS)
                .writeTimeout(TIME_60, SECONDS)
                .connectTimeout(TIME_60, SECONDS)
                .build()

        }

    }
}
