package br.com.fiap.labelmail.model

data class EmailData(
    val title: String,
    val description: String,
    val time: String,
    val categories: List<SimpleButton>,
    val userInitial: String,
    val category: String
)