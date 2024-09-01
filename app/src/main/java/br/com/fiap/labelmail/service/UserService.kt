package br.com.fiap.labelmail.service

import br.com.fiap.labelmail.model.user.Mail
import br.com.fiap.labelmail.model.user.User
import br.com.fiap.labelmail.model.user.Preferences
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService{
    @GET("/{user_id}/profile")
    fun getUserById(@Path("user_id") name: Int): Call<User>

    @GET("/{user_id}/preferences")
    fun getUserSettingsById(@Path("user_id") name: Int): Call<Preferences>

    @GET("/{user_id}/mails")
    fun getUserMailsById(@Path("user_id") name: Int): Call<List<Mail>>
}