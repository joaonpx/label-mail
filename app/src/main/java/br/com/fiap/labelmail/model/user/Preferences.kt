package br.com.fiap.labelmail.model.user

data class Preferences(
    val categories: List<Category>,
    val theme: String,
)