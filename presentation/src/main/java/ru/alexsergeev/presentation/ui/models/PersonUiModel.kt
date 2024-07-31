package ru.alexsergeev.domain.domain.models

internal data class PersonUiModel(
    val name: FullName,
    val phone: Phone,
    val avatar: String,
    val iAmGuest: Boolean = false
)

internal data class FullName(
    val firstName: String,
    val secondName: String,
)

internal data class Phone(
    val countryCode: String,
    val basicNumber: String,
)

fun mapperFromPersonDomainModel(personDomainModel: PersonDomainModel): PersonUiModel  {
    return PersonUiModel(
        name = personDomainModel.name,
        phone = personDomainModel.phone,
        avatar = personDomainModel.avatar,
    )
}

fun mapperToPersonDomainModel(personUiModel: PersonUiModel): PersonDomainModel  {
    return PersonDomainModel(
        name = personUiModel.name,
        phone = personUiModel.phone,
        avatar = personUiModel.avatar,
    )
}
