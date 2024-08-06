package ru.alexsergeev.testwb.data.dto

data class PersonDataModel(
    val name: FullName,
    val phone: Phone,
    val avatar: String,
)

data class FullName(
    val firstName: String,
    val secondName: String,
)

data class Phone(
    val countryCode: String,
    val basicNumber: String,
)