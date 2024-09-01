package br.com.fiap.labelmail.model.user

data class Category(
    val all: Boolean,
    val education: Boolean,
    val family: Boolean,
    val important: Boolean,
    val advertising: Boolean,
    val social: Boolean,
)