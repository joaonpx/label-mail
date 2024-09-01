package br.com.fiap.labelmail.model.user

data class Mail(
    val sender: User,
    val categories: List<Category>,
    val title: String,
    val body: String
)
