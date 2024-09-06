package ru.alexsergeev.presentation.ui.models

internal data class PersonUiModel(
    val name: FullName,
    val phone: Phone,
    val avatar: String,
    val tags: MutableList<String>,
    val city: String = "",
    val info: String = "",
    val myEvents: List<Int>,
    val myCommunities: List<Int>
)

internal data class FullName(
    val firstName: String,
    val secondName: String,
)

internal data class Phone(
    val countryCode: String,
    val basicNumber: String,
)

internal data class PersonUiModelMini(
    val name: FullName,
    val avatar: String,
    val tags: MutableList<String>,
)
