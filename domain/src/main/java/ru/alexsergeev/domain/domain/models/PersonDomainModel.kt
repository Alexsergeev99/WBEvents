package ru.alexsergeev.domain.domain.models

data class PersonDomainModel(
    val name: FullName,
    val phone: Phone,
    val avatar: String,
    val tags: MutableList<String>,
    val city: String = "",
    val info: String = "",
    val myEvents: List<Int> = listOf(),
    val myCommunities: List<Int> = listOf()
)

data class FullName(
    val firstName: String,
    val secondName: String,
)

data class Phone(
    val countryCode: String,
    val basicNumber: String,
)
