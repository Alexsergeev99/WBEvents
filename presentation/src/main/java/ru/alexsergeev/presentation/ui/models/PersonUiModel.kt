package ru.alexsergeev.presentation.ui.models

internal data class PersonUiModel(
    val name: FullName,
    val phone: Phone,
    val avatar: String,
    val tags: MutableList<String>
)

internal data class FullName(
    val firstName: String,
    val secondName: String,
)

internal data class Phone(
    val countryCode: String,
    val basicNumber: String,
)
