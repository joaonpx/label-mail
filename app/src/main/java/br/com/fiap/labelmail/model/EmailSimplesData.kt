package br.com.fiap.labelmail.model

data class EmailSimplesData(
    val title: String,
    val description: String,
    val time: String,
    val categories: List<SimpleButton>
)