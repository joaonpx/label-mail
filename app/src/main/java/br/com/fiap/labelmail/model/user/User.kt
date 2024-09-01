package br.com.fiap.labelmail.model.user

data class User(
    val id: Int,
    val name: String,
    val mailAddress: String,
    val password: String,
    val preferences: Preferences,
    val mails: List<Mail>,
)
