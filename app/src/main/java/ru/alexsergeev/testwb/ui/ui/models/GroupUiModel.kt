package ru.alexsergeev.domain.domain.models

data class GroupUiModel(
    val id: Int,
    val name: String,
    val people: Long,
    val groupLogo: String,
)
