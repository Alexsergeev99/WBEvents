package ru.alexsergeev.domain.domain.models

data class PersonUiModel(
    var name: String,
    var phone: String,
    var avatar: String
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
