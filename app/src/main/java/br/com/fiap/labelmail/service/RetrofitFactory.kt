package br.com.fiap.labelmail.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "http://localhost:8080"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserService(): UserService {
        return retrofitFactory.create(UserService::class.java)
    }
}
